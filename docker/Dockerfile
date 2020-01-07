FROM jenkins/jnlp-slave

LABEL maintainer="sqe_cvs@nio.com"

USER root

# 设置系统时区为北京时间
RUN mv /etc/localtime /etc/localtime.bak && \
    ln -s /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone # 解决JVM与linux系统时间不一致问题

# 支持中文
RUN apt-get update && \
    apt-get install locales -y && \
    echo "zh_CN.UTF-8 UTF-8" > /etc/locale.gen && \
    locale-gen

COPY jdk-8u212-linux-x64.tar.gz  /home/jenkins/
RUN mkdir -p /usr/java && \
    tar xzf /home/jenkins/jdk-8u212-linux-x64.tar.gz -C /usr/java && \
    update-alternatives --install /usr/bin/java java /usr/java/jdk1.8.0_212/bin/java 3000 && \
    update-alternatives --install /usr/bin/jar  jar  /usr/java/jdk1.8.0_212/bin/jar  3000 && \
    update-alternatives --install /usr/bin/javac  javac  /usr/java/jdk1.8.0_212/bin/javac  3000 && \
    update-alternatives --auto java && \
    update-alternatives --auto javac && \
    update-alternatives --auto jar && \
    rm /home/jenkins/jdk-8u212-linux-x64.tar.gz

ENV JAVA_HOME=/usr/java/jdk1.8.0_212/ \
    LANG=zh_CN.UTF-8 \
    LC_ALL=zh_CN.UTF-8

# Install maven
ENV MAVEN_VERSION 3.6.1

RUN curl -L https://mirrors.tuna.tsinghua.edu.cn/apache/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar xzf - -C /usr/share \
  && mv /usr/share/apache-maven-$MAVEN_VERSION /usr/share/maven \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn
ENV MAVEN_HOME /usr/share/maven

ADD pom.xml /home/jenkins/
ADD settings.xml /root/.m2/
RUN mvn clean compile