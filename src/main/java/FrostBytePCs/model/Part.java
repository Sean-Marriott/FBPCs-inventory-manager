package FrostBytePCs.model;

/**
 * Model class for Part objects
 * @author Sean Marriott
 */
public class Part {
    private int partID;
    private String partName;
    private String partType;
    private String partCondition;
    private float partPrice;
    private String purchaseDate;
    private String warrantyDate;
    private String partStore;

    /**
     * Basic constructor for Part objects
     * @param partID
     * @param partName
     * @param partType
     * @param partCondition
     * @param partPrice
     * @param purchaseDate
     * @param warrantyDate
     * @param partStore
     */
    public Part(int partID, String partName, String partType, String partCondition, float partPrice, String purchaseDate, String warrantyDate, String partStore) {
        this.partID = partID;
        this.partName = partName;
        this.partType = partType;
        this.partCondition = partCondition;
        this.partPrice = partPrice;
        this.purchaseDate = purchaseDate;
        this.warrantyDate = warrantyDate;
        this.partStore = partStore;
    }

    /**
     * @return the partID
     */
    public int getPartID() {
        return partID;
    }

    /**
     * @param partID the partID to set
     */
    public void setPartID(int partID) {
        this.partID = partID;
    }

    /**
     * @return the partName
     */
    public String getPartName() {
        return partName;
    }

    /**
     * @param partName the partName to set
     */
    public void setPartName(String partName) {
        this.partName = partName;
    }

    /**
     * @return the partType
     */
    public String getPartType() {
        return partType;
    }

    /**
     * @param partType the partType to set
     */
    public void setPartType(String partType) {
        this.partType = partType;
    }

    /**
     * @return the partCondition
     */
    public String getPartCondition() {
        return partCondition;
    }

    /**
     * @param partCondition the partCondition to set
     */
    public void setPartCondition(String partCondition) {
        this.partCondition = partCondition;
    }

    /**
     * @return the partPrice
     */
    public float getPartPrice() {
        return partPrice;
    }

    /**
     * @param partPrice the partPrice to set
     */
    public void setPartPrice(float partPrice) {
        this.partPrice = partPrice;
    }

    /**
     * @return the purchaseDate
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * @param purchaseDate the purchaseDate to set
     */
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * @return the warrantyDate
     */
    public String getWarrantyDate() {
        return warrantyDate;
    }

    /**
     * @param warrantyDate the warrantyDate to set
     */
    public void setWarrantyDate(String warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    /**
     * @return the partStore
     */
    public String getPartStore() {
        return partStore;
    }

    /**
     * @param partStore the partStore to set
     */
    public void setPartStore(String partStore) {
        this.partStore = partStore;
    }

}
