package com.example

import io.findify.s3mock.S3Mock
import com.amazonaws.auth.AnonymousAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client

object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello, s3")

    // create and start S3 API mock
    // FIXME port to config
    val api = S3Mock(port = 8001, dir = "/tmp/s3")
    api.start

    // AWS S3 client setup
    val credentials = new AnonymousAWSCredentials()
    val client = new AmazonS3Client(credentials)
    // use IP for endpoint address as AWS S3 SDK uses DNS-based bucket access scheme
    // resulting in attempts to connect to addresses like "bucketname.localhost"
    // which requires specific DNS setup
    client.setEndpoint("http://127.0.0.1:8001")

    // use it as usual
    // FIXME list of buckets from config
    client.createBucket("foo")
    client.createBucket("foo2")
    client.putObject("foo", "bar", "baz")


  }
}
