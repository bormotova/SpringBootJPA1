rem call mvn clean package -Dmaven.test.skip=true
call mvn exec:java -Dstart-class=hello.QueryTester -Dmaven.test.skip=true



rem call mvn clean package -Dmaven.test.skip=true
rem call mvn clean package dependency:copy-dependencies -Dmaven.test.skip=true
rem move target\gs-accessing-data-jpa-0.1.0.jar.original target\QueryTester.jar
rem java -cp "target/QueryTester.jar;target/dependency/*.jar" hello.QueryTester
rem mvn exec:java -Dstart-class=hello.QueryTester