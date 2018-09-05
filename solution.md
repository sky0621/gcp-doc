# ソリューション

## ウェブサイトの処理

https://cloud.google.com/solutions/web-serving-overview?hl=ja

Google は、Google.com、YouTube、Gmail などのサイトのコンテンツの処理に使用しているものと同じインフラストラクチャを使用して GCP を構築

|現行|プロダクト|概要|
|:--|:--|:--|
|静的ウェブサイト|GCS/Firebase Hosting|Cloud Storage バケットから静的ウェブサイトとアセットを配信します。これは GCP の最もシンプルなオプションであり、追加の操作なしで自動的にスケーリングされます。Cloud Storage を使用する Firebase Hosting は、追加の機能を提供します。|
|仮想マシン(Linux & Windows)|GCE|ユーザーのウェブ ホスティング スタックをインストール、設定、維持します。すべてのコンポーネントを制御できますが、コンポーネントのすべての稼働を維持するのもユーザーの責任となります。幅広いオプションから、負荷分散とスケーラビリティをどのように提供するか決定する必要もあります。Windows で .NET ベースのウェブサイトを実行する場合は、このオプションを選択します。|
|コンテナ|GKE|コンテナテクノロジーを使用してコードに内在している依存関係をパッケージ化し、デプロイを容易にします。その後、Kubernetes Engine を使用してコンテナのクラスタを管理します。|
|マネージドプラットフォーム|GAE|コーディングに集中し、App Engine にデプロイして、Google にシステムの管理を任せます。使用可能な言語とランタイムが規定されるスタンダード環境と、追加のオプションが提供されるものの、自己管理が必要なフレキシブル環境のどちらかを選択できます。|

### 静的ウェブサイトのホスティング

Cloud Storage は HTTP でのみコンテンツを配信します。HTTPS での配信が必要な場合は、次のセクションの Firebase Hosting をご覧ください。
https://cloud.google.com/solutions/web-serving-overview?hl=ja#firebase_hosting

#### Firebase Hosting
- SSL組み込み済み
- カスタムドメインのSSL証明書を無料プロビジョニング
- 全コンテンツがHTTPS経由
- 世界中のCDNエッジから配信



