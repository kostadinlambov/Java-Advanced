package p06_Java_Fundamentals_Retake_08_May_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_Royal_Accounting {

    private String employeeName;
    private String team;
    private int workHoursPerDay;
    private BigDecimal dailyPayment;
    private BigDecimal monthlyPayment;
    private BigDecimal dailyIncome;

    public P04_Royal_Accounting(String employeeName, String team, int workHoursPerDay, BigDecimal dailyPayment) {
        this.employeeName = employeeName;
        this.team = team;
        this.workHoursPerDay = workHoursPerDay;
        this.dailyPayment = dailyPayment;
        this.setDailyIncome();
        this.setMonthlyPayment();

    }

    private void setDailyIncome() {

        this.dailyIncome = this.dailyPayment.multiply(new BigDecimal(String.valueOf(workHoursPerDay)))
                .divide(new BigDecimal(String.valueOf((double) 24)), 1000, RoundingMode.HALF_UP);


        // this.dailyIncome = (this.dailyPayment * workHoursPerDay) / 24;
    }

    private void setMonthlyPayment() {
        this.monthlyPayment = this.dailyIncome.multiply(new BigDecimal("30"));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<P04_Royal_Accounting>> teamMap = new LinkedHashMap<>();
        Set<String> employeeNamesSet = new HashSet<>();

        Pattern regex = Pattern.compile("^(?<employeeName>[a-zA-Z]+);(?<workHoursPerDay>-*\\d+);(?<dailyPayment>-*\\d+(\\.\\d+)*);(?<team>[a-zA-z]+)$");

        while (true) {
            String inputLine = reader.readLine();
            if ("Pishi kuf i da si hodim".equalsIgnoreCase(inputLine)) {
                break;
            }

            Matcher matcher = regex.matcher(inputLine);

            if (matcher.find()) {
                String employeeName = matcher.group("employeeName");
                int workHoursPerDay = Integer.parseInt(matcher.group("workHoursPerDay"));
                BigDecimal dailyPayment = new BigDecimal(matcher.group("dailyPayment"));
                String team = matcher.group("team");


                P04_Royal_Accounting employee = new P04_Royal_Accounting(employeeName, team, workHoursPerDay, dailyPayment);

                if (!teamMap.containsKey(team)) {
                    teamMap.put(team, new ArrayList<>());
                }

                if (!employeeNamesSet.contains(employeeName)) {
                    teamMap.get(team).add(employee);
                    employeeNamesSet.add(employeeName);
                }
            }
        }

        DecimalFormat df = new DecimalFormat("0.000000");
        teamMap.entrySet().stream().sorted((x, y) -> {

            BigDecimal firstTeamTotalPayment = new BigDecimal("0");
            BigDecimal secondTeamTotalPayment = new BigDecimal("0");

            for (P04_Royal_Accounting employee : x.getValue()) {
                firstTeamTotalPayment = firstTeamTotalPayment.add(employee.monthlyPayment);
            }
            for (P04_Royal_Accounting employee : y.getValue()) {
                secondTeamTotalPayment = secondTeamTotalPayment.add(employee.monthlyPayment);
            }

            return secondTeamTotalPayment.compareTo(firstTeamTotalPayment);
        })
//            Double.compare(
//                    y.getValue().stream().mapToDouble(employeePayment -> employeePayment.monthlyPayment).sum(),
//                    x.getValue().stream().mapToDouble(employeePayment -> employeePayment.monthlyPayment).sum()))
                .forEach(team -> {
                System.out.println("Team - " + team.getKey());
                team.getValue().stream().sorted((x, y) -> {
                    int returnValue = Integer.compare(y.workHoursPerDay, x.workHoursPerDay);

                    if (returnValue == 0) {
                        returnValue = y.dailyIncome.compareTo(x.dailyIncome);
                    }

                    if (returnValue == 0) {
                        returnValue = x.employeeName.compareTo(y.employeeName);
                    }

                    return returnValue;
                })
                        .forEach(employee -> {
                            System.out.printf("$$$%s - %d - %s%n", employee.employeeName,
                                    employee.workHoursPerDay, employee.dailyIncome.setScale(6,RoundingMode.HALF_UP));
                        });
            });
        }
    }
