#bin/bash

version=1.0.19
docker build -t utiuti12345/manmaruyoyaku:${version} . && docker push utiuti12345/manmaruyoyaku:${version}