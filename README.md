# Практична робота "Поглиблене використання масивів"

Цей репозиторій містить iнструкції та стартовий код для виконання практичної роботи з теми.

## В рамках практичної роботи ви маєте зробити наступне:
1. написати клас, який містить методи для розв'язання обраного вами завдання та тестовий клас, який дозволяє перевірити його роботу. Класи мають міститись у теці ```src```. Не забуваємо про те, що основний клас **має бути універсальним, тобто він не містить інтерфейсу користувача - лише логіку (статичний метод), яка диктується завданням** (і можливо не всі його методи мають бути публічними)!
2. методу ```main``` тестового класу **не може містити ніякої логіки, пов'язаної з виконанням завдання** - лише перевіряти працездатність основного класу!
3. **README.MD репозиторію має містити опис обраного вами завдання** (краще - з картинками та форматуванням :blush:)!
4. **УВАГА!** Не слід вважати, що завдання дуже прості! Вам необхідно подбати про:
    * **оптимізацію програми - обрати оптимальні з точки зору обсягу використовуваної пам'яті типи даних**
    * **іменування змінних і констант у відповідності до рекомендацій**
    * **javadoc-коментарі для основного класу, які пояснюють що саме обчислюється і які вихідні дані для цього потрібні**
5. завдання намагаємось виконувати **без циклів - з використанням класу ````Arrays````** (див. відеолекцію, та приклад, який я там розв'язав)
6. здати завдання. **Нагадую, що здаючи завдання через Google Classroom, слід вказати посилання на створений для вас репозиторій!**

**P.S.** Ви можете обрати завдання на власний розсуд - реалізувати алгоритм, який вас зацікавив, однак якщо буде надто багато однакових класів, завдання не буде зараховано - намагайтесь робити самотужки та у власному стилі! Звісно ж, ніхто не забороняє користуватись Інтернетом, шукати й використовувати знайдене у Мережі!

----

## Список завдань (Обирала за номером в журналі)
8.  Відсортувати квадратну матрицю заданого порядку N у порядку зростання елементів (зліва-направо, зверху-вниз)

## 1. Код класу Exercise.java (у папці src)

```java
import java.util.Arrays;

/**
 * @author Kozlova
 */
public class Exercise {

    /**
     * @param matrix 
     * @return 
     */
    public static int[][] Calculate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }

        int n = matrix.length;

        int[] flatArray = Arrays.stream(matrix)
                                .flatMapToInt(Arrays::stream)
                                .toArray();

        Arrays.sort(flatArray);

        int[][] sortedMatrix = new int[n][n];
        Arrays.setAll(sortedMatrix, i -> 
            Arrays.copyOfRange(flatArray, i * n, (i + 1) * n)
        );

        return sortedMatrix;
    }
}
```

## 2. Код класу Main.java (у папці src)

```java
import java.util.Arrays;

/**
 * @author Kozlova
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Advanced Arrays Practice");
        System.out.println("Sorting matrix (left-to-right, top-to-bottom)\n");

        int[][] sourceMatrix = {
            {31, 7, 20},
            {0, 88, 43},
            {67, 12, 5}
        };

        System.out.println("Source Matrix:");
        printMatrix(sourceMatrix);

        int[][] resultMatrix = Exercise.Calculate(sourceMatrix);

        System.out.println("\nSorted Matrix:");
        printMatrix(resultMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix)
              .forEach(row -> System.out.println(Arrays.toString(row)));
    }
}
```

## 3. Результат виконання програми
![result](https://github.com/ppc-ntu-khpi/java-6-kkkseeekk/blob/master/result.png)
