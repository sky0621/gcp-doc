package com.example;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;

/**
 * Hello world!
 *
 */
public class DatasetCreator
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        BigQueryOptions bqOptions = BigQueryOptions.getDefaultInstance();
        BigQuery bq = bqOptions.getService();

        // データセット
        // 「-」は使えない。「_」は大丈夫。
//        String datasetName = "my-dataset-01";
        String datasetName = "my_dataset_01";

        DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).build();

        Dataset dataset = bq.create(datasetInfo);
        System.out.printf("Dataset %s created.\n", dataset.getDatasetId().getDataset());
    }
}
