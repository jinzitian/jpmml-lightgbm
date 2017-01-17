/*
 * Copyright (c) 2017 Villu Ruusmann
 *
 * This file is part of JPMML-LightGBM
 *
 * JPMML-LightGBM is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-LightGBM is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-LightGBM.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.lightgbm;

import java.util.ArrayList;
import java.util.List;

import org.dmg.pmml.DataField;
import org.dmg.pmml.DataType;
import org.dmg.pmml.FieldName;
import org.dmg.pmml.OpType;
import org.jpmml.converter.CategoricalLabel;
import org.jpmml.converter.Label;
import org.jpmml.converter.PMMLEncoder;

abstract
public class Classification extends ObjectiveFunction {

	private int num_class_;


	public Classification(int num_class){
		this.num_class_ = num_class;
	}

	@Override
	public Label encodeLabel(FieldName name, PMMLEncoder encoder){
		List<String> categories = new ArrayList<>();

		for(int i = 0; i < this.num_class_; i++){
			categories.add(String.valueOf(i));
		}

		DataField dataField = encoder.createDataField(name, OpType.CATEGORICAL, DataType.STRING, categories);

		return new CategoricalLabel(dataField);
	}
}