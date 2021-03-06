package br.vix.rws.eclesia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;


@Profile("prod")
@Configuration
@PropertySource(value = { "file://${HOMEPATH}/.brewer-s3.properties" }, ignoreResourceNotFound = true)
public class S3Config {
	
	@Autowired
	private Environment env;

/*
	metodo novo que nao esta dando certo
	@Bean
	public AmazonS3 amazonS3() {
		BasicAWSCredentials creds = new BasicAWSCredentials(env.getProperty("AWS_ACCESS_KEY_ID"), env.getProperty("AWS_SECRET_ACCESS_KEY")); 
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds)).build();
		Region regiao = Region.getRegion(Regions.SA_EAST_1);
		s3Client.setRegion(regiao);
		return s3Client;
	}
*/

	@Bean
	public AmazonS3 amazonS3() {
		AWSCredentials credenciais = new BasicAWSCredentials(
				env.getProperty("AWS_ACCESS_KEY_ID"), env.getProperty("AWS_SECRET_ACCESS_KEY"));
		AmazonS3 amazonS3 = new AmazonS3Client(credenciais, new ClientConfiguration());
		Region regiao = Region.getRegion(Regions.SA_EAST_1);
		amazonS3.setRegion(regiao);
		return amazonS3;
	}
	
}