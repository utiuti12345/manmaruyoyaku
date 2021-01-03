#bin/bash

docker build -t manmaru-db . && docker run -p 43306:3306 --name manmaru-db manmaru-db