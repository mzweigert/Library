#!/bin/sh

echo "************ UNDEPLOYING *******************"
./../../../../../opt/devel/glassfish3/bin/asadmin undeploy library
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
./../../../../../opt/devel/glassfish3/bin/asadmin deploy target/library.war
