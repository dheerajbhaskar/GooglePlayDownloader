package com.p.countryparser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountryParser
{
    public static void main(String[] args)
    {
        String string = "\"Brazil\" : {'TIM': '72402', 'Claro': '72405', 'Vivo': '72406', 'Oi': '72431'},\n" +
                "    \"Canada\" : {'MicroCell': '302370', 'Fido Canada': '30200001', 'Telus': '302220', 'Rogers A&T': '302720'},\n" +
                "    \"Guinea-Bissau\" : {'Orange': '63203', 'Arreba': '63202'},\n" +
                "    \"Kuwait\" : {'Viva': '41904', 'Wataniya': '41903', 'zain KW': '41902'},\n" +
                "    \"Panama\" : {'Claro': '71403', 'Cable & Wireless': '71401', 'Digicel': '71404', 'Movistar': '71402'},\n" +
                "    \"Mali\" : {'Orange': '61002', 'Malitel': '61001'},\n" +
                "    \"Lithuania\" : {'BITE': '24602', 'Tele 2': '24603', 'Omnitel': '24601'},\n" +
                "    \"Costa Rica\" : {'ICE': '71203'},\n" +
                "    \"Cambodia\" : {'Star-Cell': '45605', 'qb': '45604', 'Beeline': '45609', 'Smart Mobile': '45606', 'Mobitel': '45601', 'Metfone': '45608', 'hello': '45602', 'Mfone': '45618'},\n" +
                "    \"Bahamas\" : {'BaTelCo': '364390'},\n" +
                "    \"Aruba\" : {'SETAB': '36301', 'Digicel': '36302'},\n" +
                "    \"Arab Emirates\" : {'du': '42403', 'Etisalat': '42402'},\n" +
                "    \"Ireland\" : {'Eircom': '27207', 'Vodafone': '27201', 'O2': '27202', 'Meteor': '27203'},\n" +
                "    \"Argentina\" : {'Claro': '722330', 'Personnal': '722341', 'Nextel': '722020', 'Movistar': '722010'},\n" +
                "    \"Bolivia\" : {'Tigo': '73603', 'Nuavatel': '73601', 'Encel': '73602'},\n" +
                "    \"Cameroon\" : {'Orange': '62402', 'MTN Cameroon': '62401'},\n" +
                "    \"Burkina Faso\" : {'Telmob': '61301', 'Telecel Faso': '61303', 'Zain': '61302'},\n" +
                "    \"Cote Ivore\" : {'Koz': '61204', 'Moov': '61204'},\n" +
                "    \"Czech Republic\" : {'O2': '23002', 'Vodafone': '23003', 'T-Mobile': '23001'},\n" +
                "    \"Bahrain\" : {'VIVA': '42604', 'BaTelCo': '42601', 'zain BH': '42602'},\n" +
                "    \"Saudi Arabia\" : {'Mobily': '42003', 'Zain SA': '42004', 'Al Jawal': '42001'},\n" +
                "    \"Australia\" : {'Optus': '50502', 'OneTel': '50509', 'Vodafone': '50503', 'Telstra Mobile': '50502'},\n" +
                "    \"Columbia\" : {'Edatel': '732002', 'Comcel': '732101'},\n" +
                "    \"Algeria\" : {'Djezzy': '60302', 'Mobilis': '60301', 'Nedjma': '60303'},\n" +
                "    \"El Salvador\" : {'Claro': '70611', 'Tigo': '70603', 'Digicel': '70602', 'CTE Telecom': '70601', 'Movistar': '70604'},\n" +
                "    \"Japan\" : {'KDDI': '44008', 'SoftBank': '44004', 'DoCoMo': '44010', 'eMobile': '44000', 'TU-KA': '44081'},\n" +
                "    \"Jordan\" : {'Orange': '41677', 'Umniah': '41603', 'zain JO': '41601', 'Xpress Telecom': '41602'},\n" +
                "    \"Slovenia\" : {'Mobitel': '29341', 'Si.mobil': '29140', 'Tusmobil': '29370'},\n" +
                "    \"Guatemala\" : {'Claro': '70401', 'Comcel\\\\/Tigo': '70402', 'Movistar': '70403'},\n" +
                "    \"Chile\" : {'Claro': '73003', 'Nextel': '73009', 'Entel': '73001', 'Will': '73099', 'Movistar': '73002', 'VTR Movil': '73005'},\n" +
                "    \"Belgium\" : {'Mobistar': '20610', 'Base': '20620', 'Proximus': '20601', 'Telenet': '20605'},\n" +
                "    \"Germany\" : {'MobilCom': '26213', 'E-Plus': '26203', 'T-Mobile': '26201', 'Quam': '26214', 'O2': '26207', 'Vodafone': '26202'},\n" +
                "    \"Haiti\" : {'Digicel': '37202', 'Voila': '37201'},\n" +
                "    \"Belize\" : {'Digicell': '70267', 'Smart': '70299'},\n" +
                "    \"Hong Kong\" : {'New World PCS': '45410', 'HK Telecom': '45400', 'Smartone Mobile': '45406', 'Peoples Telephone': '45412', 'P Plus': '45422', 'Pacific Link': '45418', 'Hutchison': '45404', 'Mandarin Com.': '45416'},\n" +
                "    \"Taiwan\" : {'TransAsia': '46699', 'TINGSM': '46697', 'KG Telecom': '46688', 'TUNTEX': '46606', 'Chunghwa': '46692', 'Far Eastone': '46601', 'Mobitel': '46693'},\n" +
                "    \"Spain\" : {'Xfera': '21404', 'Telefonica': '21407', 'Amena': '21403', 'Vodafone': '21401', 'Movistar': '21402'},\n" +
                "    \"Georgia\" : {'Geocell': '28201', 'SILKNET': '28205', 'Iberiatel': '28203', 'Beeline': '28204', 'MagtiCom': '28202'},\n" +
                "    \"Pakistan\" : {'Zong': '41004', 'Ufone': '41003', 'Telenor': '41006', 'Warid': '41007', 'Mobilink': '41001', 'Vodafone': '41008'},\n" +
                "    \"Denmark\" : {'Orange': '23830', 'Debitel': '23800001', 'Telia Denmark': '23820', 'Denmark Mobil': '23801', 'Sonofon': '23802'},\n" +
                "    \"Philippines\" : {'Sun': '51505', 'Globe': '51502', 'Islacom': '51501', 'Smart': '51503'},\n" +
                "    \"Vietnam\" : {'3G EVNTelecom': '45208', 'S-Fone': '45203', 'Vietnam Mobile': '45205', 'EVNTelecom': '45206', 'Vinaphone': '45202', 'Beeline VN': '45207', 'MobiFone': '45201', 'Viettel Mobile': '45204'},\n" +
                "    \"Turkmenistan\" : {'MTS': '43801', 'TM-Cell': '43802'},\n" +
                "    \"Moldova\" : {'Orange': '25901', 'Moldcell': '25903', 'IDC': '25903'},\n" +
                "    \"Morocco\" : {'IAM': '60401', 'Meditel': '60400', 'INWI': '60402'},\n" +
                "    \"Croatia\" : {'Tele2': '21902', 'VIPNet': '21910', 'T-Mobile': '21901'},\n" +
                "    \"Luxembourg\" : {'Luxgsm': '27801', 'Orange': '27099', 'Tango': '27077'},\n" +
                "    \"Antigua\" : {'APUA': '344030', 'Digicel': '338050', 'LIME': '344920'},\n" +
                "    \"Thailand\" : {'Orange': '52010', 'GSM 1800': '52023', 'DTotal': '52018', 'AIS': '52001'},\n" +
                "    \"Switzerland\" : {'Orange': '22803', 'Swisscom': '22801', 'Sunrise': '22802'},\n" +
                "    \"Honduras\" : {'Claro': '70801', 'Digicel': '70840', 'Hondutel': '70830'},\n" +
                "    \"New Zealand\" : {'Telecom': '53000', 'Vodafone': '53001'},\n" +
                "    \"Jamaica\" : {'Claro': '338070', 'Digicel': '338050', 'LIME': '338180'},\n" +
                "    \"Albania\" : {'AMC': '27601', 'Plus': '27604', 'Vodafone': '27602', 'Eagle Mobile': '27603'},\n" +
                "    \"Estonia\" : {'EMT': '24801', 'Estonian Mobile': '24801', 'Tele 2': '24803', 'Elisa': '24802', 'RadioLinja': '24802'},\n" +
                "    \"Uruguay\" : {'Ancel': '74801', 'Claro': '74810', 'Movistar': '74807'},\n" +
                "    \"Nicaragua\" : {'Claro': '71021', 'Movistar': '71030'},\n" +
                "    \"South Africa\" : {'Vodacom': '65501', 'Cell C': '65507', 'MTN': '65510'},\n" +
                "    \"India\" : {'Escotel Mobile': '40412', 'TATA Cellular': '40407', 'Ina Spice': '40014', 'Hutch': '40405', 'Dolphin': '40468', 'Videocon': '40584', 'Idea': '40422', 'Usha Martin Tel.': '40426', 'Orange': '40020', 'Oasis': '40470', 'Bharti Telecom': '40402', 'Ushafon': '40408', 'Airtel Digilink': '40401', 'BSNL Mobile': '40455', 'INA AIRTel': '40440', 'Ushafone': '40432', 'BPL USWest': '40421', 'Spice': '40441'},\n" +
                "    \"Azerbaijan\" : {'Bakcell': '40002', 'Azercell': '40001', 'Nar Mobile': '40004', 'FONEX': '40003'},\n" +
                "    \"Uzbekistan\" : {'MTS': '73407', 'Ucell': '73405', 'Beeline': '73404'},\n" +
                "    \"Tunisia\" : {'Orange': '60501', 'Tunisiana': '60503', 'Tunicell': '60502'},\n" +
                "    \"Rwanda\" : {'Tigo': '63513', 'MTN': '63510'},\n" +
                "    \"Colombia\" : {'Tigo': '732111', 'Movistar': '732102'},\n" +
                "    \"Burundi\" : {'Omatel': '64203', 'Smart Mobile': '64207', 'Spacetel': '64201', 'Africell': '64202', 'U-COM Burundi': '64282'},\n" +
                "    \"Kenya\" : {'yu': '69305', 'Safaricom': '63902', 'Orange Kenya': '63907'},\n" +
                "    \"South Korea\" : {'SKT': '45005', 'Power 017': '45003', 'Olleh': '45008', 'LGT': '45006', 'KT': '45002'},\n" +
                "    \"Cyprus\" : {'MTN': '28010', 'Vodafone': '28001'},\n" +
                "    \"Mamibia\" : {'MTC': '64901', 'Switch': '64902', 'Leo': '64903'},\n" +
                "    \"Turkey\" : {'Avea': '28603', 'Turkcell': '28601', 'Vodafone': '28602'},\n" +
                "    \"Qatar\" : {'Qtel': '42701', 'Vodafone': '42702'},\n" +
                "    \"Netherlands Antilles\" : {'Telcell': '36251', 'UTS': '36291', 'Digicel': '36269', 'MIO': '36295', 'Bayos': '36294'},\n" +
                "    \"Italy\" : {'BLU': '22298', '3': '22299', 'Wind Tel.': '22288', 'Telecom Italia': '22201', 'Vodafone': '22210'},\n" +
                "    \"Bangladesh\" : {'TeleTalk': '47004', 'Gremenphone': '47001', 'CityCell': '47005', 'Banglalink': '47003', 'Warid Telecom': '47007', 'Airtel': '47006', 'Robi': '47002'},\n" +
                "    \"USA\" : {'Wireless 2000': '31011', 'Powertel': '31027', 'BellSouth': '31015', 'Aerial': '31031', 'Iowa Wireless': '31077', 'Western Wireless': '31026', 'Cingular': '31017', 'AT&T': '31038', 'Sprint': '31002', 'T-Mobile': '31020'},\n" +
                "    \"Lebanon\" : {'Ogero Mobile': '41505', 'Alfa': '41501', 'mtc touch': '41503'},\n" +
                "    \"Hungary\" : {'Westel GSM': '21630', 'Pannon GSM': '21601', 'Vodafone': '21670'},\n" +
                "    \"Tanzania\" : {'SasaTel': '64006', 'Vodacom': '64004', 'Life': '64007', 'tiGO': '64002', 'Zantel': '64003'},\n" +
                "    \"Mongolia\" : {'Skytel': '42891', 'Unitel': '42888', 'MobiCom': '42899', 'G-Mobile': '42898'},\n" +
                "    \"France\" : {'Bouygues Telecom': '20820', 'Orange': '20801', 'SFR': '20810'},\n" +
                "    \"Netherlands\" : {'Telfort': '20412', 'Tele 2': '20402', 'T-Mobile': '20416', '6GMobile': '20414', 'Vodafone': '20404', 'Orange': '20420', 'KPN': '20408'},\n" +
                "    \"Slovakia\" : {'Orange': '23101', 'O2': '23106', 'T-Mobile': '23102'},\n" +
                "    \"Peru\" : {'Claro': '71610', 'NEXTEL': '71607', 'Movistar': '21606'},\n" +
                "    \"Laos\" : {'Unitel': '45703', 'LaoTel': '45701', 'Tigo': '45708', 'ETL': '45702'},\n" +
                "    \"Norway\" : {'Telenor': '24201', 'NetCom': '24202'},\n" +
                "    \"Nigeria\" : {'M-TEL': '62140', 'Glo': '62150', 'MTN': '62130', 'Airtel': '62120', 'Etsalat': '62160'},\n" +
                "    \"Benin\" : {'Moov': '61602', 'Libercom': '61601', 'MTN': '61603', 'BBCOM': 'BBCOM', 'Glo': '61605'},\n" +
                "    \"Israel\" : {'Orange': '42501', 'JAWAL': '42505', 'Cellcom': '42502'},\n" +
                "    \"Singapore\" : {'StarHub': '52205', 'GSM 900': '52501', 'GSM 1800': '52502', 'MobileOne Asia': '52503', 'M1-3GSM': '52504'},\n" +
                "    \"Iceland\" : {'Simmin': '27401', 'Vodafone': '27402'},\n" +
                "    \"Senegal\" : {'Orange': '60801', 'Expresso': '60803', 'Tigo': '60802'},\n" +
                "    \"Papua New Guinea\" : {'B-Mobile': '53701', 'Digicel': '53703'},\n" +
                "    \"Togo\" : {'Togo Cell': '61501', 'Moov': '61503'},\n" +
                "    \"Trinidad and Tobago\" : {'Digicel': '37413', 'Bmobile': '37412'},\n" +
                "    \"China\" : {'China Telecom': '46005', 'China Tietong': '46020', 'China Mobile': '46000', 'China Unicom': '46001'},\n" +
                "    \"Ecuador\" : {'Porta': '74001', 'Alegro': '74002', 'Movistar': '74000'},\n" +
                "    \"Armenia\" : {'Orange': '28310', 'VivaCell': '28305', 'Beeline': '28301'},\n" +
                "    \"Oman\" : {'Oman Mobile': '41202', 'Nawras': '42203'},\n" +
                "    \"Tajikistan\" : {'Babilon-M': '43604', 'Beeline': '43605', 'MLT': '43603', 'Tcell': '43602'},\n" +
                "    \"Dominican Republic\" : {'Orange': '37001', 'Tricom': '37003', 'Claro': '37002', 'Viva': '37004'},\n" +
                "    \"Kazakhstan\" : {'Beeline': '40101', 'Kcell': '40102'},\n" +
                "    \"Poland\" : {'ERA GSM': '26002', 'IDA Centertel': '26003', 'Play': '26006', 'Polkomtel PLUS': '26001'},\n" +
                "    \"Ukraine\" : {'MTS': '25501', 'kylvstar': '25503', 'Beeline': '25502', 'Life': '25507'},\n" +
                "    \"Ghana\" : {'tiGO': '62003', 'MTN': '62001', 'Airtel': '62006', 'Vodafone': '62002'},\n" +
                "    \"Kyrgyzstan\" : {'MegaCom': '43705', 'Beeline': '43701', 'O': '43709', 'Fonex': '43703'},\n" +
                "    \"Indonesia\" : {'Ceria': '51027', 'XL': '51011', 'StarOne': '51003', 'TELKOMMobile': '51020', 'PSN': '51000', 'SMART': '51009', 'AXIS': '51008', 'TelkomFlexi': '51007', 'Fren\\\\/Hepi': '51028', '3': '51089', 'Telkomsel': '51010', 'INDOSAT': '51001'},\n" +
                "    \"Finland\" : {'Radjolinja': '24405', 'Finnet Group': '24409', '2G': '24412', 'Telia Finland': '24403', 'Sonera Corp.': '24409', 'AMT': '24414'},\n" +
                "    \"Macedonia\" : {'VIP MK': '29403', 'T-Mobile MK': '29401', 'ONE': '29402'},\n" +
                "    \"Sri Lanka\" : {'Mobitel': '41301', 'Hutch': '41308', 'Etisalat': '41303', 'Airtel': '41305', 'Dialog': '41302'},\n" +
                "    \"Sweden\" : {'Orange': '24003', 'Vodafone': '24008', '3 Sweden': '24002', 'Telia Mobitel': '24001', 'Comviq': '24007'},\n" +
                "    \"Belarus\" : {'MTS': '25702', 'Life': '25704', 'Velcom': '25701', 'DIALLOG': '25703'},\n" +
                "    \"Cap Verde\" : {'T+': '62502', 'CVMOVEL': '62501'},\n" +
                "    \"Nepal\" : {'Sky\\\\/C-Phone': '42903', 'SmartCell': '42904', 'Ncell': '42904', 'Namaste\\\\/NT Mobile': '42901'},\n" +
                "    \"Russia\" : {'North Caucasian': '25044', 'Megafon': '25002', 'BeeLine': '25099', 'New Telephone Cy': '25012', 'Don Telecom': '25010', 'MTS Moscow': '25001', 'Uratel': '25039', 'Kuban GSM': '25213', 'Zao Smarts': '25007', 'Siberian Cellular': '25005'},\n" +
                "    \"Bulgaria\" : {'M-Tel': '28401', 'Vivatel': '28401', 'Globul': '28405'},\n" +
                "    \"Romania\" : {'Mobifon': '22601', 'Cosmorom': '22603', 'Mobil Rom': '22610'},\n" +
                "    \"Angola\" : {'Unitel': '63102'},\n" +
                "    \"Portugal\" : {'Telecom Moveis': '26806', 'Optimus Telecom': '26803', 'Vodafone': '26801'},\n" +
                "    \"Mexico\" : {'Telcel': '33402', 'Lusacell': '33405', 'Nextel': '33401', 'Movistar': '33403'},\n" +
                "    \"Egypt\" : {'Etisalat': '60203', 'Vodafone': '60202', 'Mobinil': '60201'},\n" +
                "    \"Fiji\" : {'Digicel': '54202', 'Vodafone': '54201'},\n" +
                "    \"Serbia\" : {'Telenor': '22001', 'VIP Mobile': '22005', 'Telekom Srbija': '22003'},\n" +
                "    \"Botswana\" : {'Orange': '65202', 'Mascom': '65201', 'BTC Mobile': '65203'},\n" +
                "    \"United Kingdom\" : {'3': '23420', 'Manx Pronto': '23450', 'Orange': '23433', 'Jersey Telecom': '23450', 'Guermsey Tel.': '23455', 'O2': '23410', 'Vodafone': '23415', 'T-Mobile': '23430'},\n" +
                "    \"Malaysia\" : {'Celcom': '50219', 'U Mobilz': '50218', 'Maxis': '50212', 'DiGi': '50216', 'TM CDMA': '50201'},\n" +
                "    \"Austria\" : {'Mobilkom': '23101', 'Tele.ring': '23205', 'T-Mobile': '23203', '3AT': '23210'},\n" +
                "    \"Latvia\" : {'Tele 2': '24702', 'Latvian Mobile': '24701'},\n" +
                "    \"Mozambique\" : {'Vodacom': '64304', 'mCel': '64301'},\n" +
                "    \"Uganda\" : {'Orange': '64114', 'MTN': '64110', 'Zain': '64101', 'Warid Telecom': '64122'},\n" +
                "    \"Greece\" : {'Telestet': '20210', 'Cosmote': '20201', 'Wind': '20209', 'Vodafone': '20205'},\n" +
                "    \"Paraguay\" : {'Personal': '74405', 'Claro': '74402', 'Tigo': '74404', 'VOX': '74406'},\n" +
                "    \"Gabon\" : {'Liberts': '62801', 'Azur': '62804', 'Airtel': '62803', 'Moov': '62802'},\n" +
                "    \"Niger\" : {'Orange': '61404', 'Airtel': '61402', 'SahelCom': '61401', 'Telecel': '61403'},\n" +
                "    \"Bosnia-Herzegovina\" : {'BH Mobile': '21890', 'm:tel': '21805', 'HT-ERONET': '21803'}  ";

        try
        {
            String[] countries = string.split("\n");
            Pattern pattern = Pattern.compile("\"(.+)\".*:.*\\{(.+)\\}");
            Pattern pattern2 = Pattern.compile("'(.+)': '(.+)'");
            JSONArray jsonArray = new JSONArray();
            for (String cntr : countries)
            {
                Matcher matcher = pattern.matcher(cntr);
                if (matcher.find())
                {
                    JSONObject country = new JSONObject();
                    country.put("name", matcher.group(1));
                    JSONArray operators = new JSONArray();
                    String[] oprtrs = matcher.group(2).split(",");
                    for(String oprt : oprtrs)
                    {
                        Matcher matcher1 = pattern2.matcher(oprt);
                        if (matcher1.find())
                        {
                            JSONObject operator = new JSONObject();
                            operator.put("name", matcher1.group(1));
                            operator.put("code", matcher1.group(2));
                            operators.put(operator);
                        }
                    }
                    country.put("operators", operators);
                    jsonArray.put(country);
                }
            }
            System.out.println(jsonArray.toString(4));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
