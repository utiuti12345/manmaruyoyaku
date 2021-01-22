#bin/bash

version=1.0.13
docker build -t utiuti12345/manmaruyoyaku:${version} . && docker push utiuti12345/manmaruyoyaku:${version}