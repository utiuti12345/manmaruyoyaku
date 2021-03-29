#bin/bash

kubectl create secret tls manmaru-tls-certificate --key ./lego/ドメイン名.key  --cert ./lego/ドメイン名.crt -n manmaru