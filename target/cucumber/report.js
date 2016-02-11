$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumberTest.feature");
formatter.feature({
  "line": 1,
  "name": "this is an example feature file",
  "description": "",
  "id": "this-is-an-example-feature-file",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "this is basically the name of your test steps",
  "description": "Given: I navigate to a page\nWhen: I do something\nThen: I should assert an expected result",
  "id": "this-is-an-example-feature-file;this-is-basically-the-name-of-your-test-steps",
  "type": "scenario",
  "keyword": "Scenario"
});
});