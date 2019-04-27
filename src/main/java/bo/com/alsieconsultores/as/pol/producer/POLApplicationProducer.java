package bo.com.alsieconsultores.as.pol.producer;

import bo.com.alsieconsultores.as.pol.model.POLApplication;

public class POLApplicationProducer {
    public void savePersonalInfo(POLApplication polApplication) {
        // TODO here send the message to rabbitmq queue for saving the personal info to the database
        // the polApplication object will expose the personal info in the
        // polApplication.getPolApplicationPersonalInfo() property
    }

    public void storeResume(POLApplication polApplication) {
        // TODO here send the resume in pdf format to the rabbitmq queue to be stored in the existing file system
        // the polApplication object will expose the personal info in the
        // polApplication.setPolApplicationResume() property
    }
}
