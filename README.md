# Weather.com Test with TestNG and Page Object Model
This is the repository to running the test for weather.com with simple page object model using maven and surefire report


# Getting Start
1. [Maven](https://maven.apache.org/)
2. [Maven Surefire Report Plugin](https://maven.apache.org/surefire/maven-surefire-report-plugin/index.html)
3. [Maven Site Plugin](https://maven.apache.org/plugins/maven-site-plugin/)
4. [TestNG](https://testng.org/doc/)
5. [Page Object Model](https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html)

# Installation
The following softwares are required:
- [JDK 19 Installation](https://docs.oracle.com/en/java/javase/18/install/overview-jdk-installation.html)
- [Maven installation](https://maven.apache.org/install.html)

# Set up
1. Downloading maven dependencies
 
```
mvn clean install
```

# Running test cases
Using mvn site plugin to run test and generate surefire report
```
mvn site
```
Running with specific browser (dault is chrome)
```
// Run on firefox
mvn site -Dbrowser=firefox 
```

# Report
- The test report will be generated at target/site/ folder, name "surefile-report.html"
![Screenshot 2023-03-21 at 6 56 06 am](https://user-images.githubusercontent.com/47560307/226490296-2a50a982-2931-42a2-90bf-8ec482df5bb5.png)
- Report Content (some shouldBeFailed test cases were added to check the report only)
![Screenshot 2023-03-21 at 6 59 26 am](https://user-images.githubusercontent.com/47560307/226490688-d72e4f18-ba9d-4bb9-be4a-6b19f43db3ad.png)
- The weather information json file will be generated at "src/weather", name "weather_info_{contry}_{browserName}_{date}.json"
![Screenshot 2023-03-21 at 6 58 04 am](https://user-images.githubusercontent.com/47560307/226490756-dfa76b94-ecf6-42bf-b58a-b2ba56ef21ee.png)
- Weather Information Json Schema:
```JSON
[{
  date: dayTitle,
  temperature: {
      day: dayTemperature,
      night: dayHumidity,
    },
  humidity: {
      day: nightTemperature,
      night: nightHumidity,
    }
 }
]
```

# Integrate with Jenkins
- Jenkins file pipeline was added to repository to integrate with Jenkins server
- Install Maven tools for Jenkins and using pipeline from SCM and enjoy CI Jenkins
![Screenshot 2023-03-21 at 7 05 29 am](https://user-images.githubusercontent.com/47560307/226491372-617b5aca-7b8c-477c-af9a-a227f5ecb038.png)
- Jenkins jobs are running with headed mode on localhost to demo.
- After running automation test cases the surefire-report.html will be published to Jenkins job and the weather information json file will be added to artifacts
![Screenshot 2023-03-21 at 7 07 00 am](https://user-images.githubusercontent.com/47560307/226491707-baa3b051-a1d6-4bc6-82a8-41304e5aa48f.png)
- Sample Weather HTML Report
![Screenshot 2023-03-21 at 7 10 47 am](https://user-images.githubusercontent.com/47560307/226491893-817c8bdb-af17-4f16-b6a0-8b7cfc19191c.png)
- Sample Weather Information Artifacts
![Screenshot 2023-03-21 at 7 12 53 am](https://user-images.githubusercontent.com/47560307/226491990-2f9bb4dd-c402-4d63-acc0-758af668d536.png)

## ENJOYING AUTOMATION AND JENKINS!!!





