package learn.mutumju.ch01recall;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

import java.util.ArrayList;
import java.util.List;

public class StringSupplier extends ParameterSupplier {
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
        List<PotentialAssignment> list = new ArrayList<>();
        list.add(PotentialAssignment.forValue("name1", "one"));
        list.add(PotentialAssignment.forValue("name2", "two"));
        list.add(PotentialAssignment.forValue("name3", "three"));
        return list;
    }
}
