# Sử dụng OpenJDK 17 trên nền Debian đầy đủ
FROM openjdk:17-jdk-bullseye

# Cài đặt Ant và apt-utils
RUN apt-get update && apt-get install -y apt-utils && \
    apt-get install -y ant

# Thiết lập thư mục làm việc
WORKDIR /app

# Copy toàn bộ project vào container
COPY . .

# Biên dịch project bằng Ant
RUN ant clean && ant jar

# Mở cổng cho server
EXPOSE 8888  

# Chạy server
CMD ["java", "-jar", "dist/DeployChatClientServer.jar"]