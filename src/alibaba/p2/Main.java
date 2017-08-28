package alibaba.p2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }

    /**
     * 首先
     * @param lineList
     * @return
     */
    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();
        for(int i=0;i<lineList.size();i++) {
            UnilateralLine line_i = lineList.get(i);
            //处理A->B,B->A
            for(int j=0;j<lineList.size()&& i!=j;j++) {
                UnilateralLine line_j = lineList.get(j);
                if(line_i.getTType() == line_j.getTType() && line_i.sCen == line_j.eCen && line_i.eCen == line_j.sCen) {
                    result.add(line_i.getId() + "+" + line_j.getId());
                }
            }

            //处理A->B,B-C,C->A
            for(int j=0;j<lineList.size();j++) {
                UnilateralLine line_j = lineList.get(j);
                for(int k=0;k<lineList.size()&& i!=j && j!=k;k++) {
                    UnilateralLine line_k = lineList.get(k);
                    if(line_i.getTType() == line_j.getTType() && line_j.getTType()==line_k.getTType() && line_i.eCen == line_j.sCen && line_j.eCen == line_k.sCen && line_k.eCen == line_i.getSCen()) {
                        result.add(line_i.getId() + "+" + line_j.getId());
                    }
                }


                //处理A->B,B-C,C->A

            }
        }

        return result;
    }


    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        //9.6m/17.5m
        private String tType;//车型

        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro, String tType) {
            this.id = id;
            this.sCen = sCen;
            this.sPro = sPro;
            this.eCen = eCen;
            this.ePro = ePro;
            this.tType = tType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSCen() {
            return sCen;
        }

        public void setSCen(String ePro) {
            this.ePro = ePro;
        }

        public String getSPro() {
            return sPro;
        }

        public void setSPro(String sPro) {
            this.sPro = sPro;
        }

        public String getECen() {
            return eCen;
        }

        public void setECen(String eCen) {
            this.eCen = eCen;
        }

        public String getEPro() {
            return ePro;
        }

        public void setEPro(String ePro) {
            this.ePro = ePro;
        }

        public String getTType() {
            return tType;
        }

        public void setTType(String tType) {
            this.tType = tType;
        }
    }
}