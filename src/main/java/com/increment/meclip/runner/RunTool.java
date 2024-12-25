package com.increment.meclip.runner;

import cucumber.api.cli.Main;

public class RunTool {
        public static void main(String[] args) {
                String[] cucumberOptions = new String[]{
                        "--glue", "com.increment.meclip.stepDefinition",
                        "--plugin", "pretty",
                        "--plugin", "html:target/cucumber-reports/cucumber-pretty.html",
                        "--plugin", "json:target/cucumber-reports/CucumberTestReport.json",
                        "--plugin", "junit:target/cucumber-reports/cucumberReport.xml",
//                        "--plugin", "timeline:target/test-output-thread/",
                        "classpath:Features/View.feature",
                        "--tags", "@View"
                };
                Main.main(cucumberOptions);
        }
}
