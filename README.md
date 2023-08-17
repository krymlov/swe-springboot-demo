# swe-springboot-demo

To build the demo app from command line you need:
- access to public maven repository
- JDK 11 or newer

Inside the folder swe-springboot-demo run the following command:
- mvnw clean package
- java -Djava.library.path=libs -jar target/swe-springboot-2.10.03j3c.jar

then open the url in a browser to see a demo in action:
- http://localhost:8080/meta/kyiv

### Restrictions:
- project includes swe-jni-lib for Windows x64 only, copied from:
  - https://github.com/krymlov/swe-jni-lib/tree/main/x64/Release


# Swiss Ephemeris License

Please make sure before you use the project you are familiar with the Swiss Ephemeris License
- https://www.astro.com/swisseph/swephinfo_e.htm
- https://www.astro.com/swisseph/secont_e.pdf

If you want the Swiss Ephemeris Free Edition for your software project, please proceed as follows:
- make sure you understand the License conditions
- download the software
- start programming