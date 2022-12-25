import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String st = "London is the capital of Great Great Britain";
//использую функцию split(), с одиночным пробелом, чтобы можно было разбить строку на массив из нескольких слов.
        String[] words = st.split(" ");
//После этого создаю экземпляр HashMap и цикл for.
        HashMap<String, Integer> keyValue = new HashMap<>();
//Внутри цикла for использую оператор if else. Захожу в каждый элемент массива split и добавляем элементы этого массива.
        for (int i = 0; i <= words.length - 1; i++) {
//Слова мы добавляем в качестве ключей экземпляра HashMap.
            if (keyValue.containsKey(words[i])) {
//В качестве значений HashMap буду добавлять то число, сколько раз при обходе массива слов данное слово встретилось.
                int counter = keyValue.get(words[i]);
//Если в наш экземпляр HashMap мы уже добавили данное слово – при обходе мы увеличим значение, записанное в HashMap в соответствии с данным словом-ключом.
                keyValue.put(words[i], counter + 1);
            } else {
//Каждый раз, когда слово будет встречаться повторно – значение-счетчик увеличивается на 1.
// Если такое слово ранее не встречалось – значение-счетчик устанавливается на 1.
                keyValue.put(words[i], 1);
            }
        }
        System.out.println(keyValue);
    }
}