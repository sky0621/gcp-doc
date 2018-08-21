package com.example;

import com.google.cloud.bigquery.*;

import java.util.UUID;

public class Query {
    public static void main(String... args) throws Exception {
        String sql = "SELECT "
                + "CONCAT('https://stackoverflow.com/questions/', CAST(id as STRING)) as url, "
                + "view_count "
                + "FROM `bigquery-public-data.stackoverflow.posts_questions` "
                + "WHERE tags like '%google-bigquery%' "
                + "ORDER BY favorite_count DESC LIMIT 10";
        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(sql).setUseLegacySql(false).build();

        BigQuery bq = BigQueryOptions.getDefaultInstance().getService();

        JobId jobId = JobId.of(UUID.randomUUID().toString());
        Job queryJob = bq.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

        // Wait for query job to complete.
        queryJob = queryJob.waitFor();

        if (queryJob==null) {
            throw new RuntimeException("Job no longer exists.");
        }
        if (queryJob.getStatus().getError() != null) {
            throw new RuntimeException(queryJob.getStatus().getError().toString());
        }

        QueryResponse res = bq.getQueryResults(jobId);
        TableResult result = queryJob.getQueryResults();

        for (FieldValueList row : result.iterateAll()) {
            String url = row.get("url").getStringValue();
            long viewCount = row.get("view_count").getLongValue();
            System.out.printf("url: %s views: %d\n", url, viewCount);
        }
    }
}
