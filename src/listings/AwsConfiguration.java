@Configuration
@ConfigurationProperties(prefix = "praxis-intercom.aws")
public class AwsConfiguration {

    private String accessKey, secretKey, region, language;

    @Bean
    public AmazonPollyClient amazonPollyClient() {
        ...
    }

    @Bean
    public Voice voice(AmazonPollyClient polly) {
        ...
    }

    private AWSStaticCredentialsProvider credentialsProvider() {
        ...
    }
}
