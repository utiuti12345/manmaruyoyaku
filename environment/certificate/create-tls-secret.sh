#bin/bash

kubectl delete secret manmaru-tls-certificate -n manmaru
kubectl create secret tls manmaru-tls-certificate --key ./lego/ドメイン名.key  --cert ./lego/ドメイン名.crt -n manmaru
