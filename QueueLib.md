# **QueueLib Functions Explaining**
In here I will explain all the functions of QueueLib and how to use it

## Implementation In Code
In the code, make sure you have these 2 lines so you can use the functions

```java
import unit4.collectionsLib.Queue;
import TestLib.QueueLib.QueueLib;
```

Make sure before every function you write
`QueueLib.`

You can also use static imports as follows to not have to write this

```java
import static TestLib.QueueLib.QueueLib.*;
```

## `getByIndexQueue`
Retrieve an element from a queue by its **index**. Use `-1` to get the **last element**. The original queue remains intact.

### **Syntax**
```java
getByIndexQueue(Queue<T> q, int index)
```

#### Parameters:

- `q` → The queue to retrieve the element from (`Queue<T>`).
- `index` → The index of the element. Use `-1` to get the last element.

#### Returns:

- Element at the specified index if it exists
- `null` if the index is out of bounds or the queue is empty.

#### Complexity:

- **O(n)** – iterates through the queue once.

#### Example:

```java
Queue<Integer> queue = new Queue<>();
queue.insert(10);
queue.insert(20);
queue.insert(30);

// Get element at index 1
Integer value = QueueLib.getByIndexQueue(queue, 1); // 20

// Get last element
Integer last = QueueLib.getByIndexQueue(queue, -1); // 30
```

## `setByIndexQueue`
Replaces an element in a queue by its **index**.  
If the index does not exist, the queue remains **unchanged**.

### **Syntax**
```java
setByIndexQueue(Queue<T> q, int index, T newValue)
```

#### Parameters:

- `q` → The queue in which the element will be replaced (`Queue<T>`).
- `index` → The index of the element to replace.
- `newValue` → The new value to insert at the given index.

#### Returns:

- This function does not return a value (`void`).
- If the queue is empty or the index is out of bounds, no changes are made.

#### Complexity:

- **O(n)** – iterates through the queue once.

#### Example:

```java
Queue<Integer> queue = new Queue<>();
queue.insert(10);
queue.insert(20);
queue.insert(30);

// Replace element at index 1
QueueLib.setByIndexQueue(queue, 1, 99);

// Queue now contains: 10, 99, 30
```

## `insertToIndexQueue`
Inserts a value into a queue at a **specific index**.  
If the index is `-1`, the value is inserted at the **end of the queue**.

### **Syntax**
```java
insertToIndexQueue(Queue<T> q, int index, T newValue)
```

#### Parameters:

- `q` → The queue to insert the value into (`Queue<T>`).
- `index` → The index at which to insert the new value. Use `-1` to insert at the end.
- `newValue` → The value to insert into the queue.

#### Returns:

- This function does not return a value (`void`).
- If the queue is empty and `index` is not `0`, no changes are made.

#### Complexity:

- **O(n)** – iterates through the queue once.

#### Example:

```java
Queue<Integer> queue = new Queue<>();
queue.insert(10);
queue.insert(20);
queue.insert(30);

// Insert at index 1
QueueLib.insertToIndexQueue(queue, 1, 99);
// Queue now contains: 10, 99, 20, 30

// Insert at the end
QueueLib.insertToIndexQueue(queue, -1, 50);
// Queue now contains: 10, 99, 20, 30, 50
```

## `lengthQ`
Returns the **length of a queue** (number of elements).  
The original queue remains **unchanged**.

### **Syntax**
```java
lengthQ(Queue<T> q)
```

#### Parameters:

- `q` → The queue to count elements from (`Queue<T>`).

#### Returns:

- An integer representing the number of elements in the queue.

#### Complexity:

- **O(n)** – iterates through the queue once.

#### Example:

```java
Queue<Integer> queue = new Queue<>();
queue.insert(10);
queue.insert(20);
queue.insert(30);

int length = QueueLib.lengthQ(queue); // 3
```

## `copyQ`
Returns a **copy of a queue**.  
The original queue remains **unchanged**.

### **Syntax**
```java
copyQ(Queue<T> q)
```

#### Parameters:

- `q` → The queue to copy (`Queue<T>`).

#### Returns:

- A new queue containing the same elements as the original queue.
- The original queue remains unchanged.

#### Complexity:

- **O(n)** – iterates through the queue once.

#### Example:

```java
Queue<Integer> queue = new Queue<>();
queue.insert(10);
queue.insert(20);
queue.insert(30);

// Create a copy of the queue
Queue<Integer> copy = QueueLib.copyQ(queue);

// Original queue remains unchanged
// copy contains: 10, 20, 30
```

## `doesExistQ`
Checks whether a **value exists in a queue**.  
The original queue remains **unchanged**.

### **Syntax**
```java
doesExistQ(Queue<T> q, T value)
```

#### Parameters:

- `q` → The queue to search in (`Queue<T>`).
- `value` → The value to search for in the queue.

#### Returns:

- `true` if the value exists in the queue.
- `false` if the value does not exist.

#### Complexity:

- **O(n)** – iterates through the queue once.

#### Example:

```java
Queue<Integer> queue = new Queue<>();
queue.insert(10);
queue.insert(20);
queue.insert(30);

boolean exists = QueueLib.doesExistQ(queue, 20); // true
boolean notExists = QueueLib.doesExistQ(queue, 99); // false
```

## `isIdentical`
Checks whether **two queues are identical** in both **size and order**.  
Returns `false` if the number of elements or their order differs.

### **Syntax**
```java
isIdentical(Queue<T> q1, Queue<T> q2)
```

#### Parameters:

- `q1` → The first queue to compare (`Queue<T>`).
- `q2` → The second queue to compare (`Queue<T>`).

#### Returns:

- `true` if both queues contain the same elements in the same order.
- `false` if the queues differ in size or order.

#### Complexity:

- **O(n)** – iterates through both queues once.

#### Example:

```java
Queue<Integer> q1 = new Queue<>();
q1.insert(10);
q1.insert(20);
q1.insert(30);

Queue<Integer> q2 = new Queue<>();
q2.insert(10);
q2.insert(20);
q2.insert(30);

Queue<Integer> q3 = new Queue<>();
q3.insert(10);
q3.insert(30);
q3.insert(20);

boolean same1 = QueueLib.isIdentical(q1, q2); // true
boolean same2 = QueueLib.isIdentical(q1, q3); // false
```