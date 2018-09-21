## 使用可能なリソースタイプ
https://cloud.google.com/deployment-manager/docs/configuration/supported-resource-types

## EC2インスタンス生成
<pre>
$ gcloud deployment-manager deployments create qs-deployment --config vm2.yaml
The fingerprint of the deployment is OinrjWtb1Y33hzmS1zzeqg==
Waiting for create [operation-1537552295610-576654a674690-4757dd32-6855a4b8]...done.                                                                                       
Create operation operation-1537552295610-576654a674690-4757dd32-6855a4b8 completed successfully.
NAME                      TYPE                 STATE      ERRORS  INTENT
quickstart-deployment-vm  compute.v1.instance  COMPLETED  []
</pre>
