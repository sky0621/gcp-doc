# コンピューティング

## GAE (Google App Engine)

### 要するに？

PaaS

### 何のため？

迅速にWebアプリを構築するため。

### キーワード

- 負荷分散
- ヘルスチェック
- ライブマイグレーション
- Dockerコンテナも使える
- モニタリング
- ロギング
- カスタムドメインでSSL/TLS証明書使用可能
- バージョニング
- A/Bテスト
- カナリアリリース
- ブルー・グリーンデプロイメント

### コンセプト

https://cloud.google.com/appengine/docs/standard/java/concepts?authuser=0&hl=ja

## GCE (Google Compute Engine)

### 要するに？

IaaS

### 何のため？

// FIXME

### キーワード

- インスタンス高速起動
- 秒単位の課金
- 自動的に割引
- ライブマイグレーション
- グローバルな負荷分散
- LinuxとWindowsのサポート
- 格安のプリエンプティブVM（最大24h、シャットダウン前30秒猶予）

### コンセプト

https://cloud.google.com/compute/docs/concepts?authuser=0&hl=ja

## GKE (Google Kubernetes Engine)

### 要するに？

// FIXME

### 何のため？

// FIXME

### キーワード

- オートスケーリング
- モニタリング
- ロギング
- 自動アップグレード
- ヘルスチェック

### コンセプト

https://cloud.google.com/kubernetes-engine/docs/concepts/?authuser=0&hl=ja

## Google Cloud Functions

### 要するに？

サーバーレス

### 何のため？


### キーワード

- 100ミリ秒単位の課金
- イベントに対しオンデマンドで起動

### 使われ方事例

- GCSへのファイルアップロードをリッスン
- Cloud Pub/Subトピックへのメッセージ着信をリッスン
- StackdriverLoggingでのログの更新をリッスン
- Firebaseからのモバイル関連イベントをリッスン

### コンセプト

https://cloud.google.com/functions/docs/concepts?authuser=0&hl=ja

## GCR (Google Container Registry)

### 要するに？

非公開Dockerリポジトリ

### 何のため？

Dockerイメージを管理するため

### キーワード

- Cloud Source Repositories、GitHub、Bitbucketへのcommitに連動してイメージビルド→Push
- GKE, GAE, Firebase, Cloud Functionsへ直接デプロイ
- 脆弱性スキャン
- リスク高いイメージをロックダウン

### コンセプト

https://cloud.google.com/container-registry/docs/concepts?authuser=0&hl=ja

