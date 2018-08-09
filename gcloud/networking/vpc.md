# Virtual Private Cloud（VPC）

https://cloud.google.com/vpc/docs/using-vpc?authuser=1&hl=ja

- VPCネットワークには、「自動モード」と「カスタムモード」がある。
- １プロジェクトにつき、５ネットワークまで作れる。（※デフォルトも含め）

## 自動モードのVPCネットワーク作成
<pre>
$ gcloud compute networks create auto-network1 --subnet-mode auto
</pre>
<pre>
Created [https://www.googleapis.com/compute/v1/projects/XXXXXXXX/global/networks/auto-network1].
NAME           SUBNET_MODE  BGP_ROUTING_MODE  IPV4_RANGE  GATEWAY_IPV4
auto-network1  AUTO         REGIONAL

Instances on this network will not be reachable until firewall rules
are created. As an example, you can allow all internal traffic between
instances as well as SSH, RDP, and ICMP by running:

$ gcloud compute firewall-rules create <FIREWALL_NAME> --network auto-network1 --allow tcp,udp,icmp --source-ranges <IP_RANGE>
$ gcloud compute firewall-rules create <FIREWALL_NAME> --network auto-network1 --allow tcp:22,tcp:3389,icmp
</pre>

### 作成結果
リージョン毎にサブネットが１つずつ作られる。
![vpc](../../img_gcloud/vpc01.png)

#### アジアリージョンの詳細
![vpc2](../../img_gcloud/vpc02.png)

## カスタムサブネットを使用してVPCネットワーク作成
<pre>
$ gcloud compute networks create custom-network1 --subnet-mode custom
</pre>
<pre>
Created [https://www.googleapis.com/compute/v1/projects/XXXXXXXX/global/networks/custom-network1].
NAME             SUBNET_MODE  BGP_ROUTING_MODE  IPV4_RANGE  GATEWAY_IPV4
custom-network1  CUSTOM       REGIONAL

Instances on this network will not be reachable until firewall rules
are created. As an example, you can allow all internal traffic between
instances as well as SSH, RDP, and ICMP by running:

$ gcloud compute firewall-rules create <FIREWALL_NAME> --network custom-network1 --allow tcp,udp,icmp --source-ranges <IP_RANGE>
$ gcloud compute firewall-rules create <FIREWALL_NAME> --network custom-network1 --allow tcp:22,tcp:3389,icmp
</pre>

### 作成結果
カスタムの場合はサブネットは勝手に作られない。
![vpc3](../../img_gcloud/vpc03.png)
