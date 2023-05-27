FROM openjdk

COPY src pkt

WORKDIR pkt

RUN mkdir -p selenium-server
COPY selenium-server selenium-server

RUN mkdir -p bin
RUN javac -d build -cp .:selenium-server/selenium-server-4.9.1.jar -d bin ./pkt/*.java


COPY selenium-server bin/selenium-server
COPY chrome-driver/chromedriver /bin/chrome-driver/chromedriver
COPY Manifest.txt bin


WORKDIR bin
RUN jar -cvfm Program.jar Manifest.txt ./pkt/*.class
CMD ["java", "-cp", ".:selenium-server/*:Program.jar", "pkt.Program"]