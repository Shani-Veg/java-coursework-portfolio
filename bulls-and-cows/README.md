
# Bulls & Cows (Java)

Classic Bulls & Cows logic game (Mastermind-style with digits).  
Validates 4-digit input with unique digits, compares against the secret number, and prints **bulls** (correct digit & position) and **cows** (correct digit, wrong position).

**Grade:** 97/100  
**Status:** Built earlier and worked at submission time; not re-run on this machine now.

## Project Structure

```
bulls-and-cows/
├─ src/main/java/
│  ├─ GameControl.java   # Game loop & I/O, compares guesses, prints bulls/cows
│  └─ Number.java        # Secret/guess number model, validation & comparison
```

## Highlights
- Strict input validation (4 digits, all unique, no leading issues).
- Clean separation between **game logic** (`Number`) and **I/O / flow** (`GameControl`).
- Deterministic comparison (O(1) digit checks via bookkeeping).

## How to Run
- **JDK 17+**
- Open in IntelliJ IDEA and run the class that contains `public static void main(...)` (e.g., `GameControl` or `Main`, depending on your code).

Command-line (if needed):
```
javac src/main/java/*.java
java -cp src/main/java GameControl
```

## Notes
- If your files use `package ...;`, place them in matching folders under `src/main/java/`.
- Ensure file names match their `public class` names.

## Possible Improvements
- Add a hint mode or attempts counter.
- Unit tests for `Number.compare(...)` and validation.
- Support variable length (n-digit) games.
```
