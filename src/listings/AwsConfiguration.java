@Configuration
@ConfigurationProperties(prefix = "praxis-intercom.aws")
public class AwsConfiguration {

    private String accessKey, secretKey, region, language;

    @Bean
    public AmazonPollyClient amazonPollyClient() {
        var credentialsProvider = credentialsProvider();
        var clientConfiguration = new ClientConfiguration();
        var polly = new AmazonPollyClient(credentialsProvider, clientConfiguration);
        polly.setRegion(region);
        return polly;
    }

    @Bean
    public Voice voice(AmazonPollyClient polly) {
        var describeVoicesRequest = new DescribeVoicesRequest();
        var describeVoicesResult = polly.describeVoices(describeVoicesRequest);
        return describeVoicesResult.getVoices().stream()
               .filter(v -> v.getLanguageName().equals(language)).findFirst().get();
    }

    private AWSStaticCredentialsProvider credentialsProvider() {
        var basicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
        return new AWSStaticCredentialsProvider(basicAWSCredentials);
    }
}
