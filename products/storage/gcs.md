# Google Cloud Storage

- エクサバイトのデータまでスケーリングが可能
- 99.999999999% の耐久性
- 強整合性
- クラスを問わずレイテンシがミリ秒単位
- 無制限のオブジェクト ストレージ
- 個々のオブジェクトは最大 5 TB に設定
- オブジェクトの上書き頻度は 1 秒に 1 回まで、読み取り頻度に制限はありません
- 5 MB を超えるオブジェクトは、マルチパートまたは再開可能なアップロードを使用してアップロードする必要があります
- 書き込みが成功すると、GET の場合、どのようなリクエストに対しても常にオブジェクトの最新コピーが全体に返されます

## クラス別

|クラス|用途|冗長性|
|--|--|--|
|Multi-Regional|可用性に対する要求とアクセス頻度が最も高いデータ|地理的冗長性|
|Regional|リージョン内でアクセス頻度が高いデータ|リージョン単位（複数可用性ゾーン間）|
|Nearline|アクセス頻度が"月"に 1 回未満のデータ|リージョン単位|
|Coldline|アクセス頻度が"年"に 1 回未満のデータ|リージョン単位|

## オブジェクトのライフサイクル管理

- オブジェクトの有効期間（TTL）の設定
- 古いバージョンのアーカイブ

例：
- 365 日以上経過したオブジェクトのストレージ クラスを Coldline Storage にダウングレード
- 2013 年 1 月 1 日より前に作成されたオブジェクトを削除
- バージョニングが有効になっているバケット内の各オブジェクトで、最新のバージョン 3 つのみを維持

※複数の SetStorageClass 操作が指定されている場合、保存時のストレージ料金が最も安いストレージ クラスに切り替える操作が選択されます

## バケットとオブジェクトの命名ガイドライン

https://cloud.google.com/storage/docs/naming?hl=ja

## ドメイン名を持つバケットの検証

- ピリオドを含むバケット名はドメイン名として扱われます
- ドメイン名を使用するバケットを作成するには、そのドメイン名を使用する権限があることを確認する必要があります

## オブジェクトのメタデータ

https://cloud.google.com/storage/docs/metadata?hl=ja

### 固定キーメタデータ

- アクセス制御メタデータ
- Cache-Control
- Content-Disposition ... https://tools.ietf.org/html/rfc6266
- Content-Encoding
- Content-Language ... https://www.loc.gov/standards/iso639-2/php/code_list.php
- Content-Type

### カスタム メタデータ

ユーザーが追加や削除を行うことができるメタデータ

## Cloud Pub/Sub Notifications for Cloud Storage

バケット内のオブジェクトに変更が加えられるとその情報を Cloud Pub/Sub に送信
Cloud Pub/Sub のトピックを管理するのではなく、イベントへのレスポンスとしてスタンドアロン型の軽量関数のみトリガーしたい場合は、Cloud Functions を使用

現在サポートされているイベントの種類
- OBJECT_FINALIZE ... バケットで新しいオブジェクト（または既存オブジェクトの新しい世代）が正常に作成された場合 or 既存のオブジェクトをコピーまたは再作成した場合
- OBJECT_METADATA_UPDATE ... 既存オブジェクトのメタデータが変更された場合
- OBJECT_DELETE ... オブジェクトが完全に削除された場合
- OBJECT_ARCHIVE ... バケットでオブジェクトのバージョニングが有効になっている場合

## アクセス制御オプション

https://cloud.google.com/storage/docs/access-control/?hl=ja

- Identity and Access Management（IAM）権限
- アクセス制御リスト（ACL）
- 署名付き URL（クエリ文字列認証）
- 署名付きポリシー ドキュメント
- Firebase セキュリティ ルール: Firebase SDK for Cloud Storage

## リクエスト エンドポイント

https://cloud.google.com/storage/docs/request-endpoints?hl=ja

### 一般的な API リクエスト

- オブジェクトのアップロード以外の JSON API リクエストの場合

```www.googleapis.com/storage/v1/[PATH_TO_RESOURCE]```

- JSON API オブジェクトのアップロード

```www.googleapis.com/upload/storage/v1/b/[BUCKET_NAME]/o```

- バッチ リクエストの場合

```www.googleapis.com/batch/storage/v1/[PATH_TO_RESOURCE]```

### CNAME リダイレクト

CNAME レコードのホスト名部分に次の URI を追加する必要があります

```c.storage.googleapis.com.```

例：
<pre>
NAME                      TYPE     DATA
travel-maps.example.com   CNAME    c.storage.googleapis.com.
</pre>
