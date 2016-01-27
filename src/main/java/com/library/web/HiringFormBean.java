package com.library.web;

import com.library.domain.Book;
import com.library.domain.Hiring;
import com.library.domain.Reader;
import com.library.service.BookManager;
import com.library.service.ReaderManager;
import com.library.service.HiringManager;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("hiringBean")
@SessionScoped
public class HiringFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Hiring hiring = new Hiring();

	private ListDataModel<Hiring> hirings = new ListDataModel<Hiring>();

	@Inject
	private HiringManager hm;

	@Inject
	private BookManager bm;

	@Inject
	private ReaderManager rm;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String resetHiring() {
		this.hiring = new Hiring();

		return null;
	}

	public String loadHiring() {
		for (Hiring o : hm.getAllHirings()) {
			if (o.getIdHiring() == getId()) {
				this.hiring = o;
				break;
			}
		}

		return null;
	}

	public Hiring getHiring() {
		return hiring;
	}
	public void setHiring(Hiring hiring) {
		this.hiring = hiring;
	}

	public ListDataModel<Hiring> getAllHirings() {
		hirings.setWrappedData(hm.getAllHirings());
		return hirings;
	}

	// Actions
	public String addHiring() {
		for (Book b : bm.getAllBooks()) {
			if (b.getIdBook() == hiring.getIdBook()) {
				hiring.setBook(b);
				break;
			}
		}
		for (Reader r : rm.getAllReaders()) {
			if (r.getIdReader() == hiring.getIdReader()) {
				hiring.setReader(r);
				break;
			}
		}


		hm.addHiring(hiring);
		return "showHirings";
	}

	public String deleteHiring() {
		Hiring hiringToDelete = hirings.getRowData();
		hm.deleteHiring(hiringToDelete);
		return null;
	}

	public String updateHiring() {
		for (Book b : bm.getAllBooks()) {
			if (b.getIdBook() == hiring.getIdBook()) {
				hiring.setBook(b);
				break;
			}
		}
		for (Reader r : rm.getAllReaders()) {
			if (r.getIdReader() == hiring.getIdReader()) {
				hiring.setReader(r);
				break;
			}
		}


		hm.updateHiring(hiring);
		return "showHirings";
	}
}
