public class DTOFireModelParameters {

    private DTOGeneralParameters generalParameters;
    private DTOPaletteParameters paletteConfiguration;
    private DTOTemperatureParameters temperatureParameters;

    public DTOFireModelParameters(DTOGeneralParameters generalParameters, DTOPaletteParameters paletteConfiguration,
            DTOTemperatureParameters temperatureParameters) {

        this.generalParameters = generalParameters;
        this.paletteConfiguration = paletteConfiguration;
        this.temperatureParameters = temperatureParameters;
    }

    public DTOGeneralParameters getGeneralParameters() {
        return generalParameters;
    }

    public void setGeneralParameters(DTOGeneralParameters generalParameters) {
        this.generalParameters = generalParameters;
    }

    public DTOPaletteParameters getPaletteConfiguration() {
        return paletteConfiguration;
    }

    public void setPaletteConfiguration(DTOPaletteParameters paletteConfiguration) {
        this.paletteConfiguration = paletteConfiguration;
    }

    public DTOTemperatureParameters getTemperatureParameters() {
        return temperatureParameters;
    }

    public void setTemperatureParameters(DTOTemperatureParameters temperatureParameters) {
        this.temperatureParameters = temperatureParameters;
    }
}
