package com.hossam.virustracker.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hossam.virustracker.model.DeathRecorder;
import com.hossam.virustracker.model.Location;
import com.hossam.virustracker.model.RecoveryRecorder;

@Service
public class VirusDataService {

		private static String VirusDataURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
		private static String deathCasesURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Deaths.csv";
		private static String recoveryCasesURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Recovered.csv";

		private List<Location> allLocations = new ArrayList<>();
		private List<DeathRecorder> allDeathLocation = new ArrayList<>();
		private List<RecoveryRecorder> allRecoveryLocation = new ArrayList<>();

		@PostConstruct
		@Scheduled(cron = "* * 1 * * *")
		public void virusData() throws IOException, InterruptedException {

				List<Location> newLocations = new ArrayList<>();

				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(VirusDataURL)).build();
				HttpResponse<String> httpresponse = client.send(request, HttpResponse.BodyHandlers.ofString());

				StringReader csvReader = new StringReader(httpresponse.body());
				Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
				for (CSVRecord record : records) {
						Location location = new Location();
						location.setCountry(record.get("Country/Region"));
						location.setState(record.get("Province/State"));

						int latestCasesTodate = Integer.parseInt(record.get(record.size() - 1));
						int previousDayCases = Integer.parseInt(record.get(record.size() - 2));
						location.setTotalCases(latestCasesTodate);
						location.setTodayNewCases(latestCasesTodate - previousDayCases);

						newLocations.add(location);
				}
				this.allLocations = newLocations;
		}

		public List<Location> getAllLocations() {
				return allLocations;
		}

		@PostConstruct
		@Scheduled(cron = "* * 1 * * *")
		public void deathData() throws IOException, InterruptedException {

				List<DeathRecorder> newLocations = new ArrayList<>();

				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(deathCasesURL)).build();
				HttpResponse<String> httpresponse = client.send(request, HttpResponse.BodyHandlers.ofString());

				StringReader csvReader = new StringReader(httpresponse.body());
				Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
				for (CSVRecord record : records) {
						DeathRecorder deathrecorder = new DeathRecorder();
						deathrecorder.setState(record.get("Province/State"));
						deathrecorder.setCountry(record.get("Country/Region"));
						int latestCasesTodate = Integer.parseInt(record.get(record.size() - 1));
						int previousDayCases = Integer.parseInt(record.get(record.size() - 2));
						deathrecorder.setTotalDeathCases(latestCasesTodate);
						deathrecorder.setTodayDeathCases(latestCasesTodate - previousDayCases);

						newLocations.add(deathrecorder);
				}
				this.allDeathLocation = newLocations;

		}

		public List<DeathRecorder> getAllDeathCases() {
				return allDeathLocation;

		}

		@PostConstruct

		@Scheduled(cron = "* * 1 * * *")
		public void recoveryData() throws IOException, InterruptedException {

				List<RecoveryRecorder> newLocations = new ArrayList<>();

				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(recoveryCasesURL)).build();
				HttpResponse<String> httpresponse = client.send(request, HttpResponse.BodyHandlers.ofString());

				StringReader csvReader = new StringReader(httpresponse.body());
				Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
				for (CSVRecord record : records) {
						RecoveryRecorder recoveryRecorder = new RecoveryRecorder();
						recoveryRecorder.setState(record.get("Province/State"));
						recoveryRecorder.setCountry(record.get("Country/Region"));
						int latestCasesTodate = Integer.parseInt(record.get(record.size() - 1));
						int previousDayCases = Integer.parseInt(record.get(record.size() - 2));
						recoveryRecorder.setTotalRecoveryCases(latestCasesTodate);
						recoveryRecorder.setTodayRecoveryCases(latestCasesTodate - previousDayCases);

						newLocations.add(recoveryRecorder);
				}
				this.allRecoveryLocation = newLocations;

		}

		public List<RecoveryRecorder> getAllRecoveryCases() {
				return allRecoveryLocation;

		}

}
