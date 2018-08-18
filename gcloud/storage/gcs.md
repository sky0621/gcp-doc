#GCS

## バケット作成

```
gsutil mb -p [PROJECT_NAME] -c [STORAGE_CLASS] -l [BUCKET_LOCATION] gs://[BUCKET_NAME]/
```

## バケット一覧

```
gsutil ls
```

## バケットのサイズ

```
gsutil du -s gs://[BUCKET_NAME]/
```

※注: gsutil du コマンドは、オブジェクトの一覧表示リクエストを実行することで使用容量を計算するため、バケットが大きいと時間がかかることがあります。
バケット内のオブジェクトの数が数十万または数百万の場合は、バケットの合計サイズが 1 日 1 回自動的に報告されるストレージログの使用を検討してください。

## バケットのロケーションとストレージクラス

```
gsutil ls -L -b gs://[BUCKET_NAME]/
```

## バケット内のオブジェクトをコピー

```
gsutil cp -r gs://[SOURCE_BUCKET]/* gs://[DESTINATION_BUCKET]
```

## バケット内のオブジェクト及びバケット自身を削除

```
gsutil rm -r gs://[SOURCE_BUCKET]
```

## バケットラベルを追加

```
gsutil label ch -l [KEY_1]:[VALUE_1] gs://[BUCKET_NAME]/
```


## バケットラベルを表示

```
gsutil ls -L -b gs://[BUCKET_NAME]/
```

## バケットラベルを削除

```
gsutil label ch -d [KEY_1] gs://[BUCKET_NAME]/
```

## オブジェクトのメタデータを表示

```
gsutil ls -L  gs://[BUCKET_NAME]/[OBJECT_NAME]
```

## オブジェクトのメタデータを編集

```
gsutil setmeta -h "[METADATA_KEY]:[METADATA_VALUE]" gs://[BUCKET_NAME]/[OBJECT_NAME]
```


