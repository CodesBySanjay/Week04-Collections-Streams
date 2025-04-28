import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class Policy {
    String number;
    String holder;
    double premium;

    Policy(String number, String holder, double premium) {
        this.number = number;
        this.holder = holder;
        this.premium = premium;
    }

    public String toString() {
        return number + " - " + holder + " - $" + premium;
    }
}

public class Insurance {
    public static void main(String[] args) {
        List<Policy> list = Arrays.asList(
            new Policy("P1", "Samiksha", 1500),
            new Policy("P2", "Siddharth", 900),
            new Policy("P3", "Kaushik", 2200),
            new Policy("P4", "Rick", 1300),
            new Policy("P5", "Hailey", 800),
            new Policy("P6", "Ashley Hughes", 2000),
            new Policy("P7", "Aayushi Sanjay", 1700)
        );

        Stream<Policy> streamAbove1200 = list.stream();
        Stream<Policy> filteredAbove1200 = streamAbove1200.filter(p -> p.premium > 1200);
        List<Policy> above1200List = filteredAbove1200.collect(Collectors.toList());

        Stream<Policy> nameSortStream = list.stream();
        Stream<Policy> sortedByNameStream = nameSortStream.sorted(Comparator.comparing(p -> p.holder));
        List<Policy> nameSortedList = sortedByNameStream.collect(Collectors.toList());

        Stream<Policy> premiumStream = list.stream();
        DoubleStream premiumValues = premiumStream.mapToDouble(p -> p.premium);
        double totalPremium = premiumValues.sum();

        list.forEach(p -> System.out.println(p.number + ": " + p.holder + " pays $" + p.premium));

        Stream<Policy> rangeFilterStream = list.stream();
        Stream<Policy> filteredInRange = rangeFilterStream.filter(p -> p.premium >= 1000 && p.premium <= 2000);
        List<Policy> inRangeList = filteredInRange.collect(Collectors.toList());

        Stream<Policy> maxPremiumStream = list.stream();
        Optional<Policy> maxPremiumPolicy = maxPremiumStream.max(Comparator.comparingDouble(p -> p.premium));

        Stream<Policy> groupInitialStream = list.stream();
        Map<Character, List<Policy>> groupedByInitial = groupInitialStream.collect(Collectors.groupingBy(p -> p.holder.charAt(0)));

        Stream<Policy> averageStream = list.stream();
        DoubleStream premiumStreamValues = averageStream.mapToDouble(p -> p.premium);
        OptionalDouble averageOptional = premiumStreamValues.average();
        double avg = averageOptional.orElse(0);

        Stream<Policy> sortPremiumStream = list.stream();
        Stream<Policy> sortedByPremiumStream = sortPremiumStream.sorted(Comparator.comparingDouble(p -> p.premium));
        List<Policy> premiumSortedList = sortedByPremiumStream.collect(Collectors.toList());

        Stream<Policy> checkAnyStream = list.stream();
        boolean isAnyAbove2000 = checkAnyStream.anyMatch(p -> p.premium > 2000);

        Stream<Policy> rangeBucketStream = list.stream();
        Map<String, Long> premiumRangeCounts = rangeBucketStream.collect(Collectors.groupingBy(p -> {
            if (p.premium <= 1000) return "0-1000";
            else if (p.premium <= 2000) return "1001-2000";
            else return ">2000";
        }, Collectors.counting()));

        Stream<Policy> holderExtractStream = list.stream();
        Stream<String> allHolderNames = holderExtractStream.map(p -> p.holder);
        Stream<String> distinctHolderNames = allHolderNames.distinct();
        List<String> distinctNamesList = distinctHolderNames.collect(Collectors.toList());

        Stream<Policy> smithFilterStream = list.stream();
        Stream<Policy> smithMatchingStream = smithFilterStream.filter(p -> p.holder.contains("Smith"));
        List<Policy> smithMatchedList = smithMatchingStream.collect(Collectors.toList());

        Stream<Policy> policyMapStream = list.stream();
        Map<String, Double> numberToPremiumMap = policyMapStream.collect(Collectors.toMap(p -> p.number, p -> p.premium));

        String text = "the quick brown fox jumps over the lazy dog the fox was quick and fast";
        String cleanedText = text.toLowerCase().replaceAll("[^a-z ]", "");
        String[] wordArray = cleanedText.split("\\s+");
        List<String> words = Arrays.asList(wordArray);
        Stream<String> wordStream = words.stream();
        Map<String, Long> freq = wordStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Stream<Map.Entry<String, Long>> frequencyEntryStream = freq.entrySet().stream();
        Stream<Map.Entry<String, Long>> sortedFrequencyEntries = frequencyEntryStream.sorted((a, b) -> Long.compare(b.getValue(), a.getValue()));
        List<Map.Entry<String, Long>> topWords = sortedFrequencyEntries.limit(3).collect(Collectors.toList());
        String secondMost = topWords.size() > 1 ? topWords.get(1).getKey() : null;
    }
}