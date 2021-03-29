#bin/bash

version=1.0.22
docker build -t utiuti12345/manmaruyoyaku:${version} . && docker push utiuti12345/manmaruyoyaku:${version}
