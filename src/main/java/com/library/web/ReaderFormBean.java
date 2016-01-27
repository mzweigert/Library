package com.library.web;

import com.library.domain.Reader;
import com.library.service.ReaderManager;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("readerBean")
@SessionScoped
public class ReaderFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Reader reader = new Reader();

	private ListDataModel<Reader> readers = new ListDataModel<Reader>();

	@Inject
	private ReaderManager rm;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String resetReader() {
		this.reader = new Reader();

		return null;
	}

	public String loadReader() {
		for (Reader c : rm.getAllReaders()) {
			if (c.getIdReader() == getId()) {
				this.reader = c;
				break;
			}
		}

		return null;
	}

	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public ListDataModel<Reader> getAllReaders() {
		readers.setWrappedData(rm.getAllReaders());
		return readers;
	}

	// Actions
	public String addReader() {
		rm.addReader(reader);
		return "showReaders";
	}

	public String deleteReader() {
		Reader readerToDelete = readers.getRowData();
		rm.deleteReader(readerToDelete);
		return null;
	}

	public String updateReader() {
		rm.updateReader(reader);
		return "showReaders";
	}

}
