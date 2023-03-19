pipeline {

  agent any

  tools {}

  parameters {
    choice(
        name: 'browser',
        choices: ['chrome', 'firefox'],
        description:  'Select browser to run automation')
  }

  stages {
    stage('Checkout source code') {
      steps {
        git(url: 'https://github.com/quangle232/weatherselenium',
        branch: 'master',
        credentialsId: '990cc9e7-dc83-4cbf-8259-1fe882167d48')
      }
    }

    stage('Running automation test') {
      steps {
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                   sh "mvn site -Dbrowser=${browser}"
                }
      }
    }

  }

  post{
    always{
      publishHTML([
      allowMissing: false,
      alwaysLinkToLastBuild: true,
      keepAll: true,
      reportDir: "target/site",
      reportFiles: "surefire-report.html",
      reportName: "Weather HTML Report",
      reportTitles: "Weather HTML Report"
      ])

      cleanWs()
    }
  }
}
