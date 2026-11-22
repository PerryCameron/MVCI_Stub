package com.example.mvci.framework;

import javafx.scene.layout.Region;
import javafx.util.Builder;

/**
 * Base class for controllers in the MVCI architecture.
 *
 * <p>The Controller owns the Model, Interactor, and View for its MVCI unit.
 * Concrete controllers decide how each part is created by implementing
 * the create methods, then call {@link #initializeMVCI()} in their
 * constructor.</p>
 *
 * @param <M> Model type
 * @param <I> Interactor type
 * @param <V> View type (a Builder that produces a Region)
 * @param <A> action Enum used for View-to-Controller communication
 */
public abstract class ControllerBase<
        M,
        I,
        V extends Builder<Region>,
        A extends Enum<A>> {

    protected M model;
    protected I interactor;
    private V view;

    /**
     * The Region produced by the View. It is built once, on first request.
     */
    private Region region;

    protected abstract M createModel();

    protected abstract I createInteractor(M model);

    protected abstract V createView(M model);

    /**
     * Handles actions sent from the View to the Controller.
     *
     * @param actionEnum action requested by the View
     */
    public abstract void action(A actionEnum);

    /**
     * Creates the MVCI components in order: Model, Interactor, View.
     * Call this from the concrete Controller's constructor.
     */
    protected final void initializeMVCI() {
        model = createModel();
        interactor = createInteractor(model);
        view = createView(model);
    }

    /**
     * Builds and returns the JavaFX Region for this Controller's View.
     *
     * <p>The View is a {@link Builder}. The first call runs
     * {@code view.build()} and caches the result. Later calls return
     * the same Region, so the scene graph is never built twice.</p>
     *
     * @return the Region for this Controller's View
     */
    public final Region getView() {
        if (region == null) {
            region = view.build();
        }
        return region;
    }
}

// this exposes one problem in here. I should not be able to directly access view from the controller, yet I can with this framework