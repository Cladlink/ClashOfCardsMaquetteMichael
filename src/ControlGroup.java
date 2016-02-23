    /**
     * Created by cladlink on 11/01/16.
     */
    public class ControlGroup
    {

        private Model model;
        private Vue vue;
        private ControlButton controlButton;
        private ControlPlateau controlPlateau;


        public ControlGroup(Model model)
        {
            this.model = model;
            vue = new Vue(model);
            controlButton = new ControlButton(model, vue);
            controlPlateau = new ControlPlateau(model, vue);

        }
    }
