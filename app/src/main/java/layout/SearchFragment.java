package layout;
/*
 * Created by Khalin Cheverria 1501396
 * Chrysannae Mason 1503793
 * Lorenzo Buchanan 1504084
 *
 * on 3/14/2017.
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khalincheverria.mydictionary.Model.Word;
import com.khalincheverria.mydictionary.R;

/*
 * A simple {@link Fragment} subclass.
 */

@SuppressWarnings("ConstantConditions")
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_search, container, false);
        boolean isTree;
        Bundle bundle=getArguments();
        isTree=bundle.getBoolean("Tree");

        TextView nameOfWord=(TextView)view.findViewById(R.id.name_of_word);
        TextView definition=(TextView)view.findViewById(R.id.def);
        TextView partOfSpeech=(TextView)view.findViewById(R.id.pos);

        TextView position=(TextView)view.findViewById(R.id.position_found);
        TextView timeTaken=(TextView)view.findViewById(R.id.time_taken);
        Word word;
        if(isTree){
            word=(Word)bundle.getSerializable("Words");
            double time=bundle.getDouble("time");
            int count=bundle.getInt("position");

            nameOfWord.setText(word.getWord());
            partOfSpeech.setText(word.getPartOfSpeech());
            definition.setText(word.getDefinition());

            System.out.println(time);

            timeTaken.setText(String.format("%.6f seconds",time));

            position.setText(Integer.toString(count));

        }else {
            word=(Word) bundle.getSerializable("Words");
            double time=bundle.getDouble("time");
            int count=bundle.getInt("position");

            nameOfWord.setText(word.getWord());
            partOfSpeech.setText(word.getPartOfSpeech());
            definition.setText(word.getDefinition());

            timeTaken.setText(String.format("%.6f seconds",time));

            position.setText(Integer.toString(count));
        }
        return view;
    }

}
