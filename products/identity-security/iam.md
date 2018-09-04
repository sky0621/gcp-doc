# Cloud IAM (Google Cloud Identity and Access Management)

誰（メンバー）がどのリソースに対するどのような権限（役割）を持っているかを定義、管理できる。

## 誰（メンバー）

### Googleアカウント
###　サービスアカウント
アプリケーションに属するアカウント
https://support.google.com/cloud/answer/6158849#serviceaccounts
アプリが各GCPサービスにアクセスするために必要
公開鍵と秘密鍵のペアをP12ファイル or JSONファイルとして取得
秘密鍵はサーバ間のやりとりでOAuth2.0アクセストークンを要求する時に必要

### Googleグループ
個々のGoogleアカウントやサービスアカウントを束ねる

### G Suiteドメイン
1つの組織内のすべてのメンバーの仮想グループ

### Cloud Identityドメイン
1つの組織内のすべてのメンバーの仮想グループ
ただし、G Suiteアプリや機能へのアクセス不可

#### Cloud Identity
IDaasであり、企業向けモバイル管理（EMM）サービス
管理者は、ユーザー、アプリ、端末を一元管理

### allAuthenticatedUsers
Googleアカウントやサービスアカウントで認証されたすべてのユーザー

### allUsers
インターネット上の全員




