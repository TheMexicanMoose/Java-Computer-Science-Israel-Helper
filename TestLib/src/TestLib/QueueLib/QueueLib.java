package TestLib.QueueLib;

import unit4.collectionsLib.Queue;

public class QueueLib {

    // מחזיר את האיבר לפי אינדקס. -1 מחזיר את האחרון
    // מקבלת: תור, אינדקס
    // מחזירה: הערך המבוקש מהתור
    // סיבוכיות: O(n)
    // הערות: התור נשאר ללא שינוי לאחר הקריאה
    public static <T> T getByIndexQueue(Queue<T> q, int index) {
        if (q.isEmpty())
            return null;

        Queue<T> temp = new Queue<>(); // תור זמני לשחזור
        T result = null;               // האיבר המבוקש
        T lastItem = null;             // שמירת האחרון
        int count = 0;
        boolean found = false;

        while (!q.isEmpty()) {
            T current = q.remove();

            if (count == index) {
                result = current;
                found = true;
            }

            lastItem = current;
            temp.insert(current);
            count++;
        }

        // שחזור התור המקורי
        while (!temp.isEmpty())
            q.insert(temp.remove());

        if (index == -1) return lastItem;
        if (!found) return null;

        return result;
    }

    // מחליף איבר בתור לפי אינדקס
    // מקבלת: תור, אינדקס, ערך חדש
    // מחזירה/עושה: מחליפה את הערך בתור
    // סיבוכיות: O(n)
    // הערות: אם האינדקס לא קיים, התור נשאר ללא שינוי
    public static <T> void setByIndexQueue(Queue<T> q, int index, T newValue) {
        if (q.isEmpty()) return;

        Queue<T> temp = new Queue<>();
        int count = 0;

        while (!q.isEmpty()) {
            T current = q.remove();

            if (count == index)
                temp.insert(newValue);
            else
                temp.insert(current);

            count++;
        }

        while (!temp.isEmpty())
            q.insert(temp.remove());
    }

    // מחזיר את אורך התור
    // מקבלת: תור
    // מחזירה: מספר האיברים בתור
    // סיבוכיות: O(n)
    // הערות: התור נשאר ללא שינוי לאחר הספירה
    public static <T> int lengthQ(Queue<T> q) {
        Queue<T> temp = new Queue<>();
        int count = 0;

        while (!q.isEmpty()) {
            temp.insert(q.remove());
            count++;
        }

        while (!temp.isEmpty())
            q.insert(temp.remove());

        return count;
    }

    // מחזיר עותק של התור
    // מקבלת: תור
    // מחזירה: עותק של התור
    // סיבוכיות: O(n)
    // הערות: התור המקורי נשאר ללא שינוי
    public static <T> Queue<T> copyQ(Queue<T> q) {
        Queue<T> newQ = new Queue<>();
        Queue<T> temp = new Queue<>();

        while (!q.isEmpty()) {
            T item = q.remove();
            newQ.insert(item);
            temp.insert(item);
        }

        while (!temp.isEmpty())
            q.insert(temp.remove());

        return newQ;
    }

    // בודק אם איבר קיים בתור
    // מקבלת: תור, ערך לחיפוש
    // מחזירה: true אם הערך קיים בתור, אחרת false
    // סיבוכיות: O(n)
    // הערות: התור נשאר ללא שינוי
    public static <T> boolean doesExistQ(Queue<T> q, T value) {
        Queue<T> temp = new Queue<>();
        boolean found = false;

        while (!q.isEmpty()) {
            T item = q.remove();

            if (item.equals(value))
                found = true;

            temp.insert(item);
        }

        while (!temp.isEmpty())
            q.insert(temp.remove());

        return found;
    }

    // בודק אם שני תורים זהים בגודל ובסדר
    // מקבלת: תור ראשון, תור שני
    // מחזירה: true אם זהים, אחרת false
    // סיבוכיות: O(n)
    // הערות: מחזיר false אם מספר האיברים שונה או סדר שונה
    public static <T> boolean isIdentical(Queue<T> q1, Queue<T> q2) {
        Queue<T> temp1 = new Queue<>();
        Queue<T> temp2 = new Queue<>();
        boolean identical = true;

        while (identical && !(q1.isEmpty() && q2.isEmpty())) {
            if (q1.isEmpty() || q2.isEmpty()) {
                identical = false;
            } else {
                T item1 = q1.remove();
                T item2 = q2.remove();

                if (!item1.equals(item2))
                    identical = false;

                temp1.insert(item1);
                temp2.insert(item2);
            }
        }

        while (!temp1.isEmpty())
            q1.insert(temp1.remove());
        while (!temp2.isEmpty())
            q2.insert(temp2.remove());

        return identical;
    }

    // מוסיף ערך במיקום מסוים בתור
    // מקבלת: תור, אינדקס, ערך חדש
    // מחזירה/עושה: מוסיפה את הערך במקום המבוקש
    // סיבוכיות: O(n)
    // הערות: אם אינדקס = -1, מוסיפה בסוף התור
    public static <T> void insertToIndexQueue(Queue<T> q, int index, T newValue) {
        if (q.isEmpty() && index == 0) {
            q.insert(newValue);
            return;
        } else if (q.isEmpty()) {
            return;
        }

        Queue<T> temp = new Queue<>();
        int count = 0;
        boolean inserted = false;

        while (!q.isEmpty()) {
            T current = q.remove();

            if (count == index) {
                temp.insert(newValue);
                inserted = true;
            }

            temp.insert(current);
            count++;
        }

        if (!inserted && (count == index || index == -1)) {
            temp.insert(newValue);
        }

        while (!temp.isEmpty())
            q.insert(temp.remove());
    }
}
