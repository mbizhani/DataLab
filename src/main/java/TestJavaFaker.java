import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestJavaFaker {
	public static void main(String[] args) {
		final Faker faker = new Faker(new Locale("fa"));
		for (int i = 1; i < 11; i++) {
			final Name name = faker.name();
			System.out.printf("%s %s\n", name.firstName(), name.lastName());
		}

		final FakeValuesService fvs = new FakeValuesService(new Locale("fa"), new RandomService());
		for (int i = 1; i < 11; i++) {
			final String alphaNumericString = fvs.regexify("[a-z1-9]{10}");
			final Matcher alphaNumericMatcher = Pattern.compile("[a-z1-9]{10}").matcher(alphaNumericString);

			System.out.printf("%s ~=> %s\n", alphaNumericString, alphaNumericMatcher.find());
		}

		Faker faker1 = new Faker(new Random(24));
		Faker faker2 = new Faker(new Random(24));

		for (int i = 1; i < 11; i++) {
			System.out.printf("%s ! %s\n", faker1.name().firstName(), faker2.name().firstName());
		}
	}
}
