#bin/bash

version=0.1.0
docker build -t utiuti12345/manamruyoyaku:${version} . && docker push utiuti12345/manamruyoyaku:${version}