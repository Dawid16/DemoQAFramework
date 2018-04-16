This is a simple framework for web application testing site: demoqa.com created for learning automation purpose.


catalogs:

attachmentForTest- IMG_20170930_174713.jpg - attachment for testing used during registration to application test
AutoIT- script for navigation through windows tab to upload IMG_20170930_174713.jpg
drivers- all the drivers for use of different browsers
log- logging tests in two files: .log and .html
maven- maven configuration
TestsResults- results of tests passed/failed/skipped/ total

classess/properties files/packages:

src->main->java->BaseTest->ConfigurationForBrowser- Base test with Before and after method for all the test cases
src->main->java->Commands- Enum types - objects for methods in pages classess
src->main->java->Data- data defined use for parallel test - currently not in use
src->main->java->Navigation- navigation methods
src->main->java->Pages- all Pages of app
src->main->java->Utilities- useful classess (logger, random generations, test listeners, waits...)
src->main->java->resources->log4j.properties- log layout setup
src->main->java->resources->StartTests.xml- xml for tests start setup

src->test->resources->local.properties-  browser- browser for tests(code in DriverFactory class)

