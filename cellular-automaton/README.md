
# Cellular Automaton — Game of Life (JavaFX)

Conway’s Game of Life implemented with JavaFX. The app renders a grid of cells and evolves it by the classic rules.

**Grade:** 99/100  
**Status:** Built earlier and worked at submission time; not re-run on this machine now.


## Project Structure
```
cellular-automaton/
├─ src/main/java/
│  ├─ Project.java
│  ├─ Generation.java
│  └─ GenerationController.java
└─ src/main/resources/
└─ project.fxml
```

## Highlights
- Clear separation of **view** (`project.fxml`), **controller** (`GenerationController`), and **model** (`Generation`).
- Canvas-based rendering with simple click/drag toggling of cells.
- Deterministic updates: next generation computed from a snapshot (no in-place mutations).
- Lightweight: JDK + JavaFX only.

## How to Run

- **JDK 17+** and **JavaFX 17+**
- Open in IntelliJ IDEA and run `Project.java`.



--module-path "<path-to-javafx>/lib" --add-modules javafx.controls,javafx.fxml


## Notes
- Ensure the `fx:controller` in `src/main/resources/project.fxml` matches `GenerationController` (use full package name if you add one).
- `@FXML` fields/methods in `GenerationController` must match `fx:id` values in the FXML (e.g., the canvas).

## Possible Improvements
- Play/Pause with adjustable speed.
- Save/Load board states.
- Zoom/pan and larger boards with offscreen rendering.


## License
MIT (see repository root).

