#bin/bash

version=0.1.0
docker build -t utiuti12345/manmaruyoyaku:${version} . && docker push utiuti12345/manmaruyoyaku:${version}