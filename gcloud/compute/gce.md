# Google Compute Engine

## VM インスタンスの作成と起動

https://cloud.google.com/compute/docs/instances/create-start-instance?authuser=1&hl=ja

### ルートディスクに使うOSイメージのリストを確認
<pre>
$ gcloud compute images list
NAME                                                  PROJECT            FAMILY                            DEPRECATED  STATUS
centos-6-v20180716                                    centos-cloud       centos-6                                      READY
centos-7-v20180716                                    centos-cloud       centos-7                                      READY
coreos-alpha-1855-1-0-v20180807                       coreos-cloud       coreos-alpha                                  READY
coreos-beta-1828-3-0-v20180807                        coreos-cloud       coreos-beta                                   READY
coreos-stable-1800-6-0-v20180807                      coreos-cloud       coreos-stable                                 READY
cos-beta-68-10718-76-0                                cos-cloud          cos-beta                                      READY
cos-dev-69-10895-16-0                                 cos-cloud          cos-dev                                       READY
cos-stable-65-10323-98-0                              cos-cloud                                                        READY
cos-stable-66-10452-109-0                             cos-cloud                                                        READY
cos-stable-67-10575-65-0                              cos-cloud          cos-stable                                    READY
debian-9-stretch-v20180806                            debian-cloud       debian-9                                      READY
rhel-6-v20180716                                      rhel-cloud         rhel-6                                        READY
rhel-7-v20180716                                      rhel-cloud         rhel-7                                        READY
rhel-7-sap-apps-v20180716                             rhel-sap-cloud     rhel-7-sap-apps                               READY
rhel-7-sap-hana-v20180716                             rhel-sap-cloud     rhel-7-sap-hana                               READY
sles-11-sp4-v20180703                                 suse-cloud         sles-11                                       READY
sles-12-sp3-v20180703                                 suse-cloud         sles-12                                       READY
sles-15-v20180806                                     suse-cloud         sles-15                                       READY
sles-12-sp2-sap-v20180703                             suse-sap-cloud     sles-12-sp2-sap                               READY
sles-12-sp3-sap-v20180703                             suse-sap-cloud     sles-12-sp3-sap                               READY
sles-15-sap-v20180806                                 suse-sap-cloud     sles-15-sap                                   READY
ubuntu-1404-trusty-v20180722                          ubuntu-os-cloud    ubuntu-1404-lts                               READY
ubuntu-1604-xenial-v20180808                          ubuntu-os-cloud    ubuntu-1604-lts                               READY
ubuntu-1804-bionic-v20180808                          ubuntu-os-cloud    ubuntu-1804-lts                               READY
ubuntu-minimal-1604-xenial-v20180806a                 ubuntu-os-cloud    ubuntu-minimal-1604-lts                       READY
ubuntu-minimal-1804-bionic-v20180806a                 ubuntu-os-cloud    ubuntu-minimal-1804-lts                       READY
windows-server-1709-dc-core-for-containers-v20180710  windows-cloud      windows-1709-core-for-containers              READY
windows-server-1709-dc-core-v20180710                 windows-cloud      windows-1709-core                             READY
windows-server-1803-dc-core-for-containers-v20180802  windows-cloud      windows-1803-core-for-containers              READY
windows-server-1803-dc-core-v20180710                 windows-cloud      windows-1803-core                             READY
windows-server-2008-r2-dc-v20180710                   windows-cloud      windows-2008-r2                               READY
windows-server-2012-r2-dc-core-v20180710              windows-cloud      windows-2012-r2-core                          READY
windows-server-2012-r2-dc-v20180710                   windows-cloud      windows-2012-r2                               READY
windows-server-2016-dc-core-v20180710                 windows-cloud      windows-2016-core                             READY
windows-server-2016-dc-v20180710                      windows-cloud      windows-2016                                  READY
sql-2012-enterprise-windows-2012-r2-dc-v20180710      windows-sql-cloud  sql-ent-2012-win-2012-r2                      READY
sql-2012-standard-windows-2012-r2-dc-v20180710        windows-sql-cloud  sql-std-2012-win-2012-r2                      READY
sql-2012-web-windows-2012-r2-dc-v20180710             windows-sql-cloud  sql-web-2012-win-2012-r2                      READY
sql-2014-enterprise-windows-2012-r2-dc-v20180710      windows-sql-cloud  sql-ent-2014-win-2012-r2                      READY
sql-2014-enterprise-windows-2016-dc-v20180710         windows-sql-cloud  sql-ent-2014-win-2016                         READY
sql-2014-standard-windows-2012-r2-dc-v20180710        windows-sql-cloud  sql-std-2014-win-2012-r2                      READY
sql-2014-web-windows-2012-r2-dc-v20180710             windows-sql-cloud  sql-web-2014-win-2012-r2                      READY
sql-2016-enterprise-windows-2012-r2-dc-v20180710      windows-sql-cloud  sql-ent-2016-win-2012-r2                      READY
sql-2016-enterprise-windows-2016-dc-v20180710         windows-sql-cloud  sql-ent-2016-win-2016                         READY
sql-2016-standard-windows-2012-r2-dc-v20180710        windows-sql-cloud  sql-std-2016-win-2012-r2                      READY
sql-2016-standard-windows-2016-dc-v20180710           windows-sql-cloud  sql-std-2016-win-2016                         READY
sql-2016-web-windows-2012-r2-dc-v20180710             windows-sql-cloud  sql-web-2016-win-2012-r2                      READY
sql-2016-web-windows-2016-dc-v20180710                windows-sql-cloud  sql-web-2016-win-2016                         READY
sql-2017-enterprise-windows-2016-dc-v20180710         windows-sql-cloud  sql-ent-2017-win-2016                         READY
sql-2017-express-windows-2012-r2-dc-v20180710         windows-sql-cloud  sql-exp-2017-win-2012-r2                      READY
sql-2017-express-windows-2016-dc-v20180710            windows-sql-cloud  sql-exp-2017-win-2016                         READY
sql-2017-standard-windows-2016-dc-v20180710           windows-sql-cloud  sql-std-2017-win-2016                         READY
sql-2017-web-windows-2016-dc-v20180710                windows-sql-cloud  sql-web-2017-win-2016                         READY
</pre>

### VMインスタンスにSSHログイン
<pre>
$ gcloud compute --project "xxxxxxxx" ssh --zone "asia-northeast1-a" "instance-1"
</pre>

### プリエンプティブVMインスタンスの生成

https://cloud.google.com/compute/docs/instances/preemptible?hl=ja
<pre>
$ gcloud compute instances create my-preempt --zone asia-northeast1-c --preemptible
Created [https://www.googleapis.com/compute/v1/projects/xxxxxxxx/zones/asia-northeast1-c/instances/my-preempt].
NAME        ZONE               MACHINE_TYPE   PREEMPTIBLE  INTERNAL_IP       EXTERNAL_IP      STATUS
my-preempt  asia-northeast1-c  n1-standard-1  true         xxx.xxx.xxx.xxx   xxx.xxx.xxx.xxx  RUNNING
</pre>
